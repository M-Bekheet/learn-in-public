import { updateProduct } from "@/app/lib/actions";
import { fetchProduct } from "@/app/lib/data";
import styles from "@/app/ui/dashboard/users/singleUser/singleUser.module.css";
import Image from "next/image";
const SingleProductPage = async ({ params }) => {
  const product = await fetchProduct(params.id);
  return (
    <div className={styles.container}>
      <div className={styles.infoContainer}>
        <div className={styles.imgContainer}>
          <Image src={product?.img || "/noproduct.jpg"} alt="avatar" fill />
        </div>
        {product?.title}
      </div>
      <div className={styles.formContainer}>
        <form action={updateProduct} className={styles.form}>
          <input type="hidden" name="id" value={product?.id} />
          <label htmlFor="title">Title</label>
          <input
            type="text"
            name="title"
            id="title"
            defaultValue={product?.title}
          />

          <label htmlFor="number">Price</label>
          <input
            type="number"
            name="price"
            id="price"
            defaultValue={product?.price}
          />

          <label htmlFor="stock">Stock</label>
          <input
            type="number"
            name="stock"
            id="stock"
            defaultValue={product?.stock}
          />

          <label htmlFor="cat">Category</label>
          <select
            name="category"
            id="category"
            defaultValue={product?.category}
          >
            <option value="kitchen">Kitchen</option>
            <option value="computers">Computers</option>
          </select>

          <label htmlFor="desc">Description</label>
          <textarea
            type="desc"
            name="desc"
            id="desc"
            defaultValue={product?.desc}
          />

          <button type="submit">Update</button>
        </form>
      </div>
    </div>
  );
};
export default SingleProductPage;
