package appening.test1.eventscreen.gallery;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lucasr.twowayview.TwoWayView;

import appening.test1.R;
import appening.test1.eventscreen.ContentSource;
import appening.test1.eventscreen.DummyContentSource;
import appening.test1.eventscreen.EventScreen;
import appening.test1.eventscreen.SelfLoadingGalleryItem;
import appening.test1.eventscreen.SimpleEventItemAdapter;
import appening.test1.infiniscroll.EventInfo;
import appening.test1.util.Hack;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ImageGalleryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ImageGalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageGalleryFragment extends Fragment
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private View fragmentView;
    private SimpleEventItemAdapter adapter;

    ContentSource<EventInfo> contentSource;

    ;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageGallery.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageGalleryFragment newInstance(String param1, String param2)
    {
        ImageGalleryFragment fragment = new ImageGalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ImageGalleryFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_image_gallery, container, false);

        TwoWayView twoWay = (TwoWayView) fragmentView.findViewById(R.id.horizontalGallery);
        adapter = new SimpleEventItemAdapter(getActivity());
        twoWay.setAdapter(adapter);

        return fragmentView;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        contentSource = new DummyContentSource(getActivity());

        for (int eventIndex = 0; eventIndex < 4; eventIndex++)
        {
            SelfLoadingGalleryItem item = new SelfLoadingGalleryItem(contentSource, EventScreen.getThreadPool());
            adapter.add(item);
        }

        new AsyncTask<Void, Void, Void>()
        {
            @Hack("Some images retain the Progress Bar indefinitely, and don't show the real content." +
                    "This code waits a bit and forces the TwoWayView to re-draw most items - a stupid hack." +
                    "Review problem Later.")
            @Override
            protected Void doInBackground(Void... params)
            {
                boolean done = false;
                while (!done)
                {
                    try
                    {
                        Thread.sleep(1000);
                        done = true;
                    } catch (InterruptedException i)
                    {
                    }
                }
                return null;
            }


            @Override
            protected void onPostExecute(Void result)
            {
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }

    // TODO: Rename method, update argument and hook method into UI event

    public void onButtonPressed(Uri uri)
    {
        if (mListener != null)
        {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        contentSource = new DummyContentSource(activity);
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
