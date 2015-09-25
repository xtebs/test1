package appening.test1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.origamilabs.library.views.StaggeredGridView;



public class StaggViewMainActivity extends Activity {


    /**
     * Images are taken by Romain Guy ! He's a great photographer as well as a
     * great programmer. http://www.flickr.com/photos/romainguy
     */
    private static Context context;
    private String urls[] = {
            "http://farm7.staticflickr.com/6101/6853156632_6374976d38_c.jpg",
            "http://farm8.staticflickr.com/7232/6913504132_a0fce67a0e_c.jpg",
            "http://farm5.staticflickr.com/4133/5096108108_df62764fcc_b.jpg",
            "http://farm5.staticflickr.com/4074/4789681330_2e30dfcacb_b.jpg",
            "http://farm9.staticflickr.com/8208/8219397252_a04e2184b2.jpg",
            "http://farm9.staticflickr.com/8483/8218023445_02037c8fda.jpg",
            "http://farm9.staticflickr.com/8335/8144074340_38a4c622ab.jpg",
            "http://farm9.staticflickr.com/8060/8173387478_a117990661.jpg",
            "http://farm9.staticflickr.com/8056/8144042175_28c3564cd3.jpg",
            "http://farm9.staticflickr.com/8183/8088373701_c9281fc202.jpg",
            "http://farm9.staticflickr.com/8185/8081514424_270630b7a5.jpg",
            "http://farm9.staticflickr.com/8462/8005636463_0cb4ea6be2.jpg",
            "http://farm9.staticflickr.com/8306/7987149886_6535bf7055.jpg",
            "http://farm9.staticflickr.com/8444/7947923460_18ffdce3a5.jpg",
            "http://farm9.staticflickr.com/8182/7941954368_3c88ba4a28.jpg",
            "http://farm9.staticflickr.com/8304/7832284992_244762c43d.jpg",
            "http://farm9.staticflickr.com/8163/7709112696_3c7149a90a.jpg",
            "http://farm8.staticflickr.com/7127/7675112872_e92b1dbe35.jpg",
            "http://farm8.staticflickr.com/7111/7429651528_a23ebb0b8c.jpg",
            "http://farm9.staticflickr.com/8288/7525381378_aa2917fa0e.jpg",
            "http://farm6.staticflickr.com/5336/7384863678_5ef87814fe.jpg",
            "http://farm8.staticflickr.com/7102/7179457127_36e1cbaab7.jpg",
            "http://farm8.staticflickr.com/7086/7238812536_1334d78c05.jpg",
            "http://farm8.staticflickr.com/7243/7193236466_33a37765a4.jpg",
            "http://farm8.staticflickr.com/7251/7059629417_e0e96a4c46.jpg",
            "http://farm8.staticflickr.com/7084/6885444694_6272874cfc.jpg"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stagg);
        context = this.getApplicationContext();
        StaggeredGridView gridView = (StaggeredGridView) this.findViewById(R.id.staggeredGridView1);

        int margin = getResources().getDimensionPixelSize(R.dimen.margin);

        gridView.setItemMargin(margin); // set the GridView margin

        gridView.setPadding(margin, 0, margin, 0); // have the margin on the sides as well

        StaggeredAdapter adapter = new StaggeredAdapter(context, R.id.imageView1, urls);

        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
