import { Alert, Image, StyleSheet, Text, View } from "react-native";
import OutlinedButton from "../UI/OutlinedButton";
import { Colors } from "../../constants/colors";
import * as Location from "expo-location";
import { useState, useEffect } from "react";
import { getAddress, getMapPreview } from "../../utils/location";
import {
  useIsFocused,
  useNavigation,
  useRoute,
} from "@react-navigation/native";

function LocationPicker({ onPickLocation }) {
  const [status, requestPermission] = Location.useForegroundPermissions();
  const [pickedLocation, setPickedLocation] = useState(null);
  const navigation = useNavigation();
  const route = useRoute();

  const isFocused = useIsFocused();

  useEffect(() => {
    if (route.params && isFocused) {
      const mapPickedLocation = route.params.selectedLocation;
      setPickedLocation(mapPickedLocation);
    }
  }, [route, isFocused]);

  useEffect(() => {
    async function handleLocation() {
      if (pickedLocation) {
        const address = await getAddress(
          pickedLocation.lat,
          pickedLocation.lng
        );
        onPickLocation({ ...pickedLocation, address });
      }
    }
    handleLocation();
  }, [pickedLocation, onPickLocation]);

  async function getLocationHandler() {
    const granted = await verifyPermission();
    if (!granted) return;

    let location = await Location.getCurrentPositionAsync({
      accuracy: Location.Accuracy.Highest,
    });
    setPickedLocation({
      lat: location.coords.latitude,
      lng: location.coords.longitude,
    });
  }

  async function verifyPermission() {
    if (status !== "granted") {
      const res = await requestPermission();
      if (!res.granted) {
        Alert.alert(
          "Insufficient Permissions!",
          "You need to grant location permission to use this application."
        );
        return false;
      }
    }
    return true;
  }

  let locationPreview = <Text>No location picket yet.</Text>;

  if (pickedLocation)
    locationPreview = (
      <Image
        source={{
          uri: getMapPreview(pickedLocation?.lat, pickedLocation?.lng),
        }}
        style={styles.image}
      />
    );

  function pickOnMapHandler() {
    navigation.navigate("Map");
  }

  return (
    <View>
      <View style={styles.mapPreview}>{locationPreview}</View>
      <View style={styles.actions}>
        <OutlinedButton icon="location" onPress={getLocationHandler}>
          Locate User
        </OutlinedButton>
        <OutlinedButton icon="map" onPress={pickOnMapHandler}>
          Pick on Map
        </OutlinedButton>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  mapPreview: {
    marginVertical: 8,
    width: "100%",
    height: 200,
    marginVertical: 8,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: Colors.primary100,
    borderRadius: 4,
    overflow: "hidden",
  },
  actions: {
    flexDirection: "row",
    justifyContent: "space-around",
    alignItems: "center",
  },
  image: {
    width: "100%",
    height: "100%",
  },
});

export default LocationPicker;
