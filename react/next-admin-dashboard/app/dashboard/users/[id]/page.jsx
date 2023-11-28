import { fetchUser } from "@/app/lib/data";
import { updateUser } from "@/app/lib/actions";

import styles from "@/app/ui/dashboard/users/singleUser/singleUser.module.css";
import Image from "next/image";
const SingleUserPage = async ({ params }) => {
  const user = await fetchUser(params.id);
  return (
    <div className={styles.container}>
      <div className={styles.infoContainer}>
        <div className={styles.imgContainer}>
          <Image src={user?.img || "/noavatar.png"} alt="avatar" fill />
        </div>
        {user?.username}
      </div>
      <div className={styles.formContainer}>
        <form action={updateUser} className={styles.form}>
          <input type="hidden" name="id" value={user?.id} />
          <label htmlFor="username" placeholder="John Doe">
            Username
          </label>
          <input
            type="text"
            name="username"
            id="username"
            defaultValue={user?.username}
          />

          <label htmlFor="email" placeholder="Email">
            Email
          </label>
          <input
            type="text"
            name="email"
            id="email"
            defaultValue={user?.email}
          />

          <label htmlFor="password" placeholder="Password">
            Password
          </label>
          <input type="password" name="password" id="password" />

          <label htmlFor="phone" placeholder="Phone">
            Phone
          </label>
          <input
            type="phone"
            name="phone"
            id="phone"
            defaultValue={user?.phone}
          />

          <label htmlFor="address" placeholder="New York">
            Address
          </label>
          <textarea
            type="address"
            name="address"
            id="address"
            defaultValue={user?.address}
          />

          <label htmlFor="isAdmin">Is Admin?</label>
          <select name="isAdmin" id="isAdmin" defaultValue={user?.isAdmin}>
            <option value={true}>Yes</option>
            <option value={false}>No</option>
          </select>

          <label htmlFor="isActive">Is Active?</label>
          <select name="isActive" id="isActive" defaultValue={user?.isActive}>
            <option value={true}>Yes</option>
            <option value={false}>No</option>
          </select>
          <button type="submit">Update</button>
        </form>
      </div>
    </div>
  );
};
export default SingleUserPage;
