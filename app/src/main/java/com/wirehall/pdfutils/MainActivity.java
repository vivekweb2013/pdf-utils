package com.wirehall.pdfutils;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {
  private static final String TAG = MainActivity.class.getName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setupNavDrawer();
    AppRater.launchIfRequired(this);
  }

  private void setupNavDrawer() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar); // set the toolbar

    DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
    NavigationView navView = findViewById(R.id.nav_view);
    navView.setItemIconTintList(null);

    ActionBarDrawerToggle toggle =
        new ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.nav_drawer_open_description,
            R.string.nav_drawer_close_description);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();
    navView.setNavigationItemSelectedListener(this);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
    int itemId = item.getItemId();

    if (itemId == R.id.nav_settings) {
      HelperUtils.openSettings(this);
    } else if (itemId == R.id.nav_privacy_policy) {
      HelperUtils.openPrivacyPolicyIntent(this);
    } else if (itemId == R.id.nav_source_code) {
      HelperUtils.openSourceCodeIntent(this);
    } else if (itemId == R.id.nav_bug_report) {
      HelperUtils.openBugReportIntent(this);
    } else if (itemId == R.id.nav_rate) {
      HelperUtils.openRateIntent(this);
    } else if (itemId == R.id.nav_twitter) {
      HelperUtils.openTwitterIntent(this);
    } else if (itemId == R.id.nav_about) {
      HelperUtils.openAboutDialog(this);
    }

    drawerLayout.closeDrawer(GravityCompat.START);
    return false;
  }
}
