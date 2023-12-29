import { Image, ScrollView, StyleSheet, Text, View } from "react-native";
import OutlinedButton from "../components/UI/OutlinedButton";
import { Colors } from "../constants/colors";
import { useEffect, useState } from "react";
import { fetchPlace } from "../utils/database";

function PlaceDetails({ route, navigation }) {
  const [place, setPlace] = useState();
  const placeId = route.params.placeId;

  useEffect(() => {
    async function loadPlace() {
      const loadedPlace = await fetchPlace(placeId);
      setPlace(loadedPlace);
      navigation.setOptions({
        title: loadedPlace.title,
      });
    }
    loadPlace();
  }, [placeId]);

  console.log(place);
  function showMapHandler() {
    navigation.navigate("Map", {
      lat: place.location.lat,
      lng: place.location.lng,
    });
  }

  if (!place)
    return (
      <View style={styles.fallback}>
        <Text style={styles.text}>Loading Place Details</Text>
      </View>
    );

  return (
    <ScrollView style={styles.screen}>
      <Image style={styles.image} source={{ uri: place.imageUri || "" }} />
      <View style={styles.locationContainer}>
        <View style={styles.addressContainer}>
          <Text style={styles.text}>{place?.address || ""}</Text>
        </View>
        <OutlinedButton icon="map" onPress={showMapHandler}>
          View on Map
        </OutlinedButton>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  fallback: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    color: Colors.primary500,
  },
  image: {
    height: "35%",
    minHeight: 300,
    width: "100%",
  },
  locationContainer: {
    justifyContent: "center",
    alignItems: "center",
  },
  addressContainer: {
    padding: 20,
  },
  text: {
    color: Colors.primary500,
  },
});
export default PlaceDetails;
