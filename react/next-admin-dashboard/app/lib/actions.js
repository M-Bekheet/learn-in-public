"use server";

import { revalidatePath } from "next/cache";
import { Product, User } from "./models";
import { connectToDB } from "./utils";
import { redirect } from "next/navigation";
import bcrypt from "bcrypt";
import { signIn, signOut } from "../auth";

const addUser = async (formData) => {
  const data = Object.fromEntries(formData);
  try {
    connectToDB();
    const salt = await bcrypt.genSalt(10);
    const newPassword = await bcrypt.hash(data.password, salt);
    data.password = newPassword;
    const user = new User(data);
    await user.save();
  } catch (error) {
    console.error(error);
    throw new Error("Failed to add user");
  }
  revalidatePath("/dashboard/users");
  redirect("/dashboard/users");
};

const deleteUser = async (formData) => {
  try {
    connectToDB();
    const id = formData.get("id");
    await User.findByIdAndDelete(id);
  } catch (error) {
    console.error(error);
    throw new Error("Failed to delete user");
  }
  revalidatePath("/dashboard/users");
};

const updateUser = async (formData) => {
  const { id, username, email, password, phone, address, isAdmin, isActive } =
    Object.fromEntries(formData);
  const updateFields = {
    username,
    email,
    password,
    phone,
    address,
    isAdmin,
    isActive,
  };
  Object.keys(updateFields).forEach(
    (key) =>
      [undefined, "", null].includes(updateFields[key]) &&
      delete updateFields[key]
  );
  try {
    connectToDB();
    await User.findByIdAndUpdate(id, updateFields);
  } catch (error) {
    console.error(error);
    throw new Error("Failed to update user data");
  }
  revalidatePath("/dashboard/users");
  redirect("/dashboard/users");
};

const addProduct = async (formData) => {
  const data = Object.fromEntries(formData);
  try {
    connectToDB();

    const product = new Product(data);
    await product.save();
  } catch (error) {
    console.error(error);
    throw new Error("Failed to add product");
  }
  revalidatePath("/dashboard/products");
  redirect("/dashboard/products");
};

const updateProduct = async (formData) => {
  const { id, title, price, stock, category, desc } =
    Object.fromEntries(formData);
  const updateFields = {
    title,
    price,
    stock,
    category,
    desc,
  };
  Object.keys(updateFields).forEach(
    (key) =>
      [undefined, "", null].includes(updateFields[key]) &&
      delete updateFields[key]
  );
  try {
    connectToDB();
    await Product.findByIdAndUpdate(id, updateFields);
  } catch (error) {
    console.error(error);
    throw new Error("Failed to update product data");
  }
  revalidatePath("/dashboard/products");
  redirect("/dashboard/products");
};

const deleteProduct = async (formData) => {
  try {
    connectToDB();
    const id = formData.get("id");
    await Product.findByIdAndDelete(id);
  } catch (error) {
    console.error(error);
    throw new Error("Failed to delete product");
  }
  revalidatePath("/dashboard/products");
};

const authenticate = async (prevState, formData) => {
  const { username, password } = Object.fromEntries(formData);
  try {
    await signIn("credentials", { username, password });
  } catch (error) {
    console.error(error);
    return "Wrong Credentials";
  }
};

const logout = async () => {
  try {
    await signOut();
  } catch (error) {
    console.error(error);
    throw error;
  }
};

export {
  addUser,
  addProduct,
  updateUser,
  deleteProduct,
  updateProduct,
  deleteUser,
  authenticate,
  logout,
};
