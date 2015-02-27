package androidemo.liang.com.android_tableview;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class TableViewDemo extends Activity {

    private ImageView mPrimaryImage;
    private final static String[] STATE_OF_USA = {"Washington", "Oregon", "California",
            "Nevada", "Idaho", "Montana", "Utah", "Arizona", "New Mexico", "Texas",
            "North Dakota", "South Dakota", "Nebraska", "kansas", "Oklahoma", "Minnesota",
            "Lowa", "Missouri", "Arkansas", "Louisiana", "Mississippi", "Tennessee",
            "Indiana", "Wisconsin", "Michigan", "Kentucky", "Alabama", "Georgia",
            "South Carolina", "Florida", "North Carolina", "Virginia", "Ohio",
            "West Virginia", "New York"};
    private static final int PADDING_LEFT_DP = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_view_demo);

        // Load flag image from res/drawable folder
        mPrimaryImage = (ImageView)findViewById(R.id.primaryImageView);
        mPrimaryImage.setImageResource(R.drawable.north_dakota);

        // Add states flags to table
        // firstly you should create TableRow
        // and create three new TextView, after that
        // place those TextView collection into TableRow
        // Finally append this TableRow you just built
        // to TableLayout.
        TableRow flagsRow = new TableRow(this);
        flagsRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        // create three text view
        TextView firstColumn = new TextView(this);
        TextView secondColumn = new TextView(this);
        TextView thirdColumn = new TextView(this);
        ViewGroup.LayoutParams cellParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                .WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        firstColumn.setLayoutParams(cellParams);
        secondColumn.setLayoutParams(cellParams);
        thirdColumn.setLayoutParams(cellParams);
        firstColumn.setBackgroundResource(R.drawable.border_light_line);
        secondColumn.setBackgroundResource(R.drawable.border_light_line);
        thirdColumn.setBackgroundResource(R.drawable.border_light_line);
        firstColumn.setPadding(PADDING_LEFT_DP, 0, 0, 0);
        secondColumn.setPadding(PADDING_LEFT_DP, 0, 0, 0);
        thirdColumn.setPadding(PADDING_LEFT_DP, 0, 0, 0);
        firstColumn.setText(STATE_OF_USA[0]);
        thirdColumn.setText(STATE_OF_USA[1]);
        secondColumn.setText(STATE_OF_USA[2]);
        flagsRow.addView(firstColumn, new TableRow.LayoutParams());
        flagsRow.addView(secondColumn, new TableRow.LayoutParams());
        flagsRow.addView(thirdColumn, new TableRow.LayoutParams());

        TableLayout stateTable = (TableLayout)findViewById(R.id.tableLayoutOfUSAState);
        stateTable.setStretchAllColumns(true);
        stateTable.addView(flagsRow, new TableLayout.LayoutParams(TableLayout.LayoutParams
                .MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_table_view_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
