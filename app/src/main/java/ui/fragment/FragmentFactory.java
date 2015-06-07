package ui.fragment;
import android.support.v4.app.Fragment;


public class FragmentFactory {

    private FragmentName fn;

    public FragmentFactory(FragmentName fn){
        this.fn = fn;
    }

    public Fragment build() {
        switch (fn) {
            case HOME_SCREEN:
                return HomeFragment.newInstance(fn);
            case LOGIN_FRAGMENT:
                return LoginFragment.newInstance(fn);
            case REGISTRATION_FRAGMENT:
                return RegistrationFragment.newInstance(fn);
            case MENU_FRAGMENT:
                return MenuFragment.newInstance(fn);
            case GROUP_LIST_FRAGMENT:
                return GroupListFragment.newInstance(fn);
            case EVENT_LIST_FRAGMENT:
                return EventListFragment.newInstance(fn);
            default:
                break;
        }
        return null;
    }

    public static enum FragmentName {//
        HOME_SCREEN, //
        LOGIN_FRAGMENT, //
        REGISTRATION_FRAGMENT, //
        MENU_FRAGMENT, //
        GROUP_LIST_FRAGMENT, //
        EVENT_LIST_FRAGMENT, //
    }



}
