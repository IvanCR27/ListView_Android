package mx.com.cuechos.listview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class ListViewActivity extends ListActivity {

    static final String nombres[] = new String[]{"Ivan", "Misael", "Smirna", "Sarahi",
            "Alejandro", "Daniela", "Esther", "Jonathan", "Estrella"};

    enum PARAMETROS {
        NOMBRE,
        ID,
        NOMBRE_EDITADO
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view, nombres));
        final ListView listView = getListView();

        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intento = new Intent(ListViewActivity.this, EditarNombreActivity.class);
                intento.putExtra(PARAMETROS.NOMBRE.name(), ((TextView) view).getText());
                intento.putExtra(PARAMETROS.ID.name(), position);
                ListViewActivity.this.startActivityForResult(intento, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("intent", "RqC:" + requestCode + ",RsC:" + resultCode + ",Data:" + data.getStringExtra(PARAMETROS.NOMBRE_EDITADO.name()));
        int position = data.getIntExtra(PARAMETROS.ID.name(), 1);
        nombres[position] = data.getStringExtra(PARAMETROS.NOMBRE_EDITADO.name());
        ((ArrayAdapter) getListAdapter()).notifyDataSetChanged();
    }

}
