import { Product, User } from "./models";
import { connectToDB } from "./utils";

export const ITEMS_PER_PAGE = 50;

export const fetchUsers = async (query, page) => {
  try {
    const regex = new RegExp(query, "i");

    connectToDB();
    const count = await User.find({ username: { $regex: regex } }).count();
    const users = await User.find({ username: { $regex: regex } })
      .limit(ITEMS_PER_PAGE)
      .skip(ITEMS_PER_PAGE * (page - 1))
      .lean();
    return { users, count };
  } catch (error) {
    console.error(error);
    throw new Error("Failed to fetch users!");
  }
};
export const fetchUser = async (userId) => {
  try {
    connectToDB();
    const user = await User.findById(userId);
    return user;
  } catch (error) {
    console.error(error);
    throw new Error("Failed to fetch user");
  }
};
export const fetchProducts = async (query, page) => {
  try {
    const regex = new RegExp(query, "i");
    connectToDB();
    const count = await Product.find({ title: { $regex: regex } }).count();
    const products = await Product.find({ title: { $regex: regex } })
      .limit(ITEMS_PER_PAGE)
      .skip(ITEMS_PER_PAGE * (page - 1))
      .lean();
    return { products, count };
  } catch (error) {
    throw new Error("Failed to fetch products!");
  }
};

export const fetchProduct = async (productId) => {
  try {
    connectToDB();
    const product = await Product.findById(productId);
    return product;
  } catch (error) {
    console.error(error);
    throw new Error("Failed to fetch product");
  }
};
