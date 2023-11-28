const Page = () => {
  const handleSubmit = async (formData) => {
    "use server";
    console.log(formData);
    console.log("Yes");
  };
  return (
    <form action={handleSubmit}>
      <input type="text" name="username" />
      <button>Submit</button>
    </form>
  );
};
export default Page;
