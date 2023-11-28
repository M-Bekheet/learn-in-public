import Pagination from "@/app/ui/dashboard/pagination/pagination";
import Search from "@/app/ui/dashboard/search/search";
import styles from "@/app/ui/dashboard/products/products.module.css";
import Image from "next/image";
import Link from "next/link";
import { fetchProducts } from "@/app/lib/data";
import { deleteProduct } from "@/app/lib/actions";

const ProductsPage = async ({ searchParams }) => {
  const page = +searchParams.page || 1;
  const query = searchParams.q;
  const { products, count } = await fetchProducts(query, page);
  return (
    <div className={styles.container}>
      <div className={styles.top}>
        <Search placeholder="Search for a product..." />
        <Link href="products/add">
          <button className={styles.addButton}>Add New</button>
        </Link>
      </div>
      <table className={styles.table}>
        <thead>
          <tr>
            <td>Title</td>
            <td>Description</td>
            <td>Created At</td>
            <td>Price</td>
            <td>Stock</td>
            <td>Action</td>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product._id}>
              <td>
                <div className={styles.product}>
                  <Image
                    src={product.img || "/noproduct.jpg"}
                    alt="product"
                    className={styles.productImage}
                    width={40}
                    height={40}
                  />
                  {product.title}
                </div>
              </td>
              <td>{product.desc}</td>
              <td>{product.createdAt?.toString().slice(4, 15)}</td>
              <td>{product.price}</td>
              <td>${product.stock}</td>
              <td>
                <div className={styles.buttons}>
                  <Link href={`products/${product._id}`}>
                    <button
                      type="button"
                      className={`${styles.button} ${styles.view}`}
                    >
                      View
                    </button>
                  </Link>
                  <form action={deleteProduct}>
                    <input type="hidden" value={product._id} name="id" />
                    <button
                      type="submit"
                      className={`${styles.button} ${styles.delete}`}
                    >
                      Delete
                    </button>
                  </form>
                </div>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Pagination count={count} />
    </div>
  );
};
export default ProductsPage;
