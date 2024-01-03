import { StatusBar } from "expo-status-bar";
import { Alert, Button, Platform, StyleSheet, Text, View } from "react-native";
import * as Notifications from "expo-notifications";
import { useEffect } from "react";
import Constants from "expo-constants";
import * as Device from "expo-device";

Notifications.setNotificationHandler({
  handleNotification: async () => {
    return {
      shouldPlaySound: false,
      shouldSetBadge: false,
      shouldShowAlert: true,
    };
  },
});

export default function App() {
  // request notification permission
  useEffect(() => {
    async function configureNotifications() {
      if (!Device.isDevice) return;
      const settings = await Notifications.getPermissionsAsync();

      let granted =
        settings.granted ||
        settings.ios?.status ===
          Notifications.IosAuthorizationStatus.PROVISIONAL;
      if (!granted) {
        const { status } = await Notifications.requestPermissionsAsync({
          ios: {
            allowAlert: true,
            allowBadge: true,
            allowSound: true,
            allowAnnouncements: true,
          },
          android: {
            allowAlert: true,
            allowBadge: true,
            allowSound: true,
            allowAnnouncements: true,
          },
        });
        granted = status === "granted";
      }

      if (!granted) {
        return Alert.alert(
          "Permission Required",
          "Push notifications need appropriate permissions"
        );
      }

      /* 
        This token is typically used to be stored on your DB by sending it to the backend and whenever the device needs to be notified, they push this through FCM on android or APN on iOS. Expo manages both at the same time though. 
        */
      const pushTokenData = await Notifications.getExpoPushTokenAsync({
        // - In order to have this projectId, make sure that you have eas configured by running this command: npx eas build:configure
        projectId: Constants.expoConfig.extra.eas.projectId,
      });

      if (Platform.os === "android") {
        Notifications.setNotificationChannelAsync("default", {
          name: "default",
          importance: Notifications.AndroidImportance.DEFAULT,
        });
      }
    }
    configureNotifications();
  }, []);

  // handle notification receiving
  useEffect(() => {
    const subscription1 = Notifications.addNotificationReceivedListener(
      (notification) => {
        console.log(notification.request.content.data.userName);
      }
    );

    const subscription2 = Notifications.addNotificationResponseReceivedListener(
      (response) => {
        console.log(response.notification.request.content.data.userName);
      }
    );
    return () => {
      subscription1.remove();
      subscription2.remove();
    };
  }, []);

  // This is mimicking the server behavior. You can also try this tool by Expo: https://expo.dev/notifications
  async function sendPushNotificationHandler() {
    fetch("https://exp.host/--/api/v2/push/send", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        to: process.env.EXPO_PUBLIC_MY_DEVICE_TOKEN,
        title: "hello",
        body: "world",
      }),
    });
  }

  async function scheduleNotificationHandler() {
    await Notifications.scheduleNotificationAsync({
      content: {
        title: "My First Local Notification",
        body: "This is the body of the notification",
        data: {
          userName: "Bekheet",
        },
      },
      trigger: {
        seconds: 1,
      },
    });
  }
  return (
    <View style={styles.container}>
      <Button
        title="Schedule Notification"
        onPress={scheduleNotificationHandler}
      />
      <Button
        title="Send Push Notification"
        onPress={sendPushNotificationHandler}
      />
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
