/* 
  - Splitting the project into separate modules helps with the code organization and avoiding the pollution of the codebase possible collisions.
  - Both ways can be tree-shaken to remove the the unused modules from the final bundle (performance gain).
  - While there is a big debate on the benefits of ES6 import/export over commonjs require/modules.export, ES6 way is almost the standard now.
  - ES6 way has a dynamic import as shown below.
*/

// modules import: logUtility is a default export, timeNow & add are named exports
import logUtility, { timeNow, add as addValues } from "./utils";

timeNow();
logUtility("Hello");
console.log(addValues(10, 2));

async function dynamicImport() {
  // This will only be imported when the `dynamicImport` function is called
  const module = await import("./utils");
  module.identify("Mahmoud", "Bekheet");

  //module.default is the log method
}

dynamicImport();
