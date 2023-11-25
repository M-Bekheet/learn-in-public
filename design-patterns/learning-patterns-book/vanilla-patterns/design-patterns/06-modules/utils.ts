export function add(m: number, n: number) {
  return m + n;
}

export function timeNow() {
  return new Date().toLocaleTimeString();
}

export function identify(firstName: string, lastName: string) {
  console.log(`Hello! My name is ${firstName} ${lastName}`);
}

// default export
export default function log(msg: string) {
  console.log(timeNow(), ":", msg, "\n");
}
