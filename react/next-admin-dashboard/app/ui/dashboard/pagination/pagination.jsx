"use client";
import { ITEMS_PER_PAGE } from "@/app/lib/data";
import { usePathname, useRouter, useSearchParams } from "next/navigation";
import styles from "./pagination.module.css";

const Pagination = ({ count }) => {
  const searchParams = useSearchParams();
  const params = new URLSearchParams(searchParams);
  const pathname = usePathname();
  const { replace } = useRouter();
  const page = +params.get("page") || 1;

  const hasNext = ITEMS_PER_PAGE * page < count;
  const hasPrev = page > 1;

  const handleChangePage = (type) => {
    if (type === "next") params.set("page", page + 1);
    else params.set("page", page - 1);
    replace(`${pathname}/?${params}`);
  };

  return (
    <div className={styles.container}>
      <div className={styles.buttons}>
        <button
          type="button"
          className={styles.button}
          onClick={() => handleChangePage("prev")}
          disabled={!hasPrev}
        >
          Previous
        </button>
        &nbsp; &nbsp;
        <button
          type="button"
          className={styles.button}
          onClick={() => handleChangePage("next")}
          disabled={!hasNext}
        >
          Next
        </button>
      </div>
    </div>
  );
};
export default Pagination;
