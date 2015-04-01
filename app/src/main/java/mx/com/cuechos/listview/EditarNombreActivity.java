package mx.com.cuechos.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static mx.com.cuechos.listview.ListViewActivity.PARAMETROS;


public class EditarNombreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_nombre);
        Button botonEditar = (Button) findViewById(R.id.btnEditar);
        final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtNombre.setText(getIntent().getStringExtra(PARAMETROS.NOMBRE.name()));
        final int posicion = getIntent().getIntExtra(PARAMETROS.ID.name(), 1);
        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regreso = new Intent();
                regreso.putExtra(PARAMETROS.NOMBRE_EDITADO.name(), txtNombre.getText().toString());
                regreso.putExtra(PARAMETROS.ID.name(), posicion);
                EditarNombreActivity.this.setResult(RESULT_OK, regreso);
                EditarNombreActivity.this.finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_editar_nombre, menu);
        return true;
    }
}
