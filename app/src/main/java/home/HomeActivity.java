package home;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import ui.fragment.FragmentFactory;
import ui.fragment.HomeFragment;

import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.groupscheduleapp.groupscheduleapp.R;


public class HomeActivity extends ActionBarActivity {

    private static final String TAG = HomeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState == null) {

            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Group Schedule");
//            getActionBar();//.setHomeButtonEnabled(true);

//            actionBar.setHomeButtonEnabled(true);

            FragmentFactory ff = new FragmentFactory(FragmentFactory.FragmentName.HOME_SCREEN);
            Fragment fragment = ff.build();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
//                this.finish();
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

//        return super.onOptionsItemSelected(item);
    }

    public void onClickLoginButton(View v){
        Log.d(TAG, "Login Button Clicked");
        replaceFragment(FragmentFactory.FragmentName.LOGIN_FRAGMENT);
    }

    public void onClickRegistrationButton(View v) {
        Log.d(TAG, "Registration Button Clicked");
        replaceFragment(FragmentFactory.FragmentName.REGISTRATION_FRAGMENT);
    }

    private void replaceFragment(FragmentFactory.FragmentName fn){
        Fragment ff = new FragmentFactory(fn).build();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.maincontainer, ff);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "back Clicked");
        super.onBackPressed();
    }
//
//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_login, container, false);
//            return rootView;
//        }
//    }

}
