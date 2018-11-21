package net.ddns.hdmccullough.intentr.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ddns.hdmccullough.intentr.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AppSelectorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AppSelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppSelectorFragment extends Fragment {
    private static final String TAG = AppSelectorFragment.class.getSimpleName();

    private View mFragmentRoot;

    private OnFragmentInteractionListener mListener;

    //region Constructor & Factory Methods
    public AppSelectorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AppSelectorFragment.
     */
    public static AppSelectorFragment newInstance() {
        Log.d(TAG, "newInstance");

        AppSelectorFragment fragment = new AppSelectorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }
    //endregion

    //region Fragment Lifecycle Methods
    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach");
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        mFragmentRoot = inflater.inflate(
                R.layout.fragment_app_selector, container, false
        );
        return mFragmentRoot;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    //endregion

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
    }
}
