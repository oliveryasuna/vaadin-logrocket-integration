package com.oliveryasuna.vaadin.logrocket.demo.ui.layout;

import com.oliveryasuna.vaadin.logrocket.demo.ui.view.AboutView;
import com.oliveryasuna.vaadin.logrocket.demo.ui.view.HomeView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;

@Layout
public final class MainLayout extends AppLayout {

  // Constructors
  //--------------------------------------------------

  private MainLayout() {
    super();

    final SideNav nav = new SideNav();
    nav.addItem(new SideNavItem("Home", HomeView.class));
    nav.addItem(new SideNavItem("About", AboutView.class));

    addToDrawer(nav);
  }

}
