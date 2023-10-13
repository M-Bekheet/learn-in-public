// Generics

/*
*
  ===> Ex1
*  
*/

type G1<S> = {
  data: S;
};

type E1 = G1<string>;
type E2 = G1<{ firstName: string }>;

/*
*
  ===> Ex2: With Functions
*  
*/

const makeFetch = <TData>(url: string): Promise<TData> =>
  fetch(url).then((res) => res.json());

const students = makeFetch<string[]>("/students");
const count = makeFetch<{ count: number }>("/count");

/*
*
  ===> Ex3: You can use generics with JS Set
*  
*/

const set = new Set<number>();

set.add(1);
// set.add("text") //error

/*
*
  ===> Ex4: Inferring types (notice the addition of the id type)
*  
*/

const addIdToObject = <T>(obj: T) => ({ ...obj, id: 3 });

const student = addIdToObject({ name: "Jack", age: 32 });

/*
*
  ===> Ex5: ReturnType & Awaited
*  
*/

//we extends a function as ReturnType only works on functions so we tell TS that T type is a function
type Result<T extends (...args: any) => any> = ReturnType<T>;
type Res = Result<() => "Hello">;

type Result2<T> = Awaited<Promise<T>>;
type Res2 = Result2<number>;

//both together
type GetPromiseReturnType<T extends (...args: any) => any> = Awaited<
  ReturnType<T>
>;

type Result3 = GetPromiseReturnType<() => Promise<{ firstName: string }>>;

/*
*
  ===> Ex6: Add function constraint
*  
*/

// Record: set object with constraint types (string, number, ...)
const getHighestValue = <TObj extends Record<string, number>>(
  obj: TObj
): {
  key: keyof TObj;
  value: number;
} => {
  const keys = Object.keys(obj);
  let key = keys[0];
  let highest = obj[keys[0]];

  for (const item of keys) {
    if (obj[item] > highest) {
      highest = obj[item];
      key = item;
    }
  }

  return { key, value: highest };
};

const pair = getHighestValue({
  a: 1,
  b: 2,
  c: 3,
  // d: false /==> error
});

/*
*
  ===> Ex7: constraint a return type to a specific key of enumerable
*  
*/

const getValue = <TObj, TKey extends keyof TObj>(obj: TObj, key: TKey) => {
  return obj[key];
};

const val = getValue({ a: 1, b: true, c: "text" }, "c");

/*
*
  ===> Ex8: defaults in type arguments
*  
*/

const createSet = <T = string>() => new Set<T>();
const set1 = createSet<number>();
const set2 = createSet<[]>();
const set3 = createSet(); // using the default string argument

export {};
