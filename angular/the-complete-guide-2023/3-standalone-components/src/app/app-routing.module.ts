import { NgModule } from "@angular/core";
import { Route, RouterModule } from "@angular/router";

const routes: Route[] = [
  {
    path: "",
    loadComponent: () =>
      import("./welcome/welcome.component").then((mod) => mod.WelcomeComponent),
  },
  {
    path: "about",
    loadComponent: () =>
      import("./about/about.component").then((mod) => mod.AboutComponent),
  },
  {
    path: "dashboard",
    loadChildren: () =>
      import("./dashboard/routes").then((mod) => mod.DASHBOARD_ROUTES),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
