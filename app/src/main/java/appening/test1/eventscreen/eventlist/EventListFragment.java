package appening.test1.eventscreen.eventlist;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.joda.time.DateTime;

import appening.test1.R;
import appening.test1.eventscreen.ContentSource;
import appening.test1.eventscreen.DummyContentSource;
import appening.test1.eventscreen.EventScreen;
import appening.test1.eventscreen.SelfLoadingGalleryItem;
import appening.test1.infiniscroll.EventInfo;
import appening.test1.util.ToDo;
import appening.test1.util.UITest;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@ToDo("Find a way to set each row's height to a percentage of the parent listview - layout_weight doesn't work")
public class EventListFragment extends Fragment
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View fragmentView;
    private ListView eventRowList;

    private SimpleEventRowAdapter simpleEventRowAdapter = null;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventListFragment newInstance(String param1, String param2)
    {
        EventListFragment fragment = new EventListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public EventListFragment()
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
        fragmentView = inflater.inflate(R.layout.fragment_event_list, container, false);
        eventRowList = (ListView) fragmentView.findViewById(R.id.event_row_list_view);
        simpleEventRowAdapter = new SimpleEventRowAdapter(getActivity());
        eventRowList.setAdapter(simpleEventRowAdapter);
        eventRowList.setOverScrollMode(ListView.OVER_SCROLL_ALWAYS);

        return fragmentView;
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
    }

    @Override
    @UITest("This method adds data to the event list when this fragment is started")
    public void onResume()
    {
        super.onResume();
        ContentSource<EventInfo> source = new DummyContentSource(getActivity());
        for (int rowIndex = 0; rowIndex < 4; rowIndex++)
        {
            EventRow row = new EventRow(DateTime.now(), null);

            for (int eventIndex = 0; eventIndex < 5; eventIndex++)
            {
                SelfLoadingGalleryItem item = new SelfLoadingGalleryItem(source, EventScreen.getThreadPool());
                row.addItem(item);
            }
            simpleEventRowAdapter.add(row);
        }
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
