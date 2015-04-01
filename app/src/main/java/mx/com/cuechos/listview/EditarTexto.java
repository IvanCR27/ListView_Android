package mx.com.cuechos.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditarTexto extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_texto);
        Button botonEditar = (Button) this.findViewById(R.id.btnEditar);
        final EditText editarTexto = (EditText) this.findViewById(R.id.txtNombre);
        editarTexto.setText(this.getIntent().getStringExtra("nombre"));
        botonEditar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent regreso = new Intent();
                regreso.putExtra("editarNombre", editarTexto.getText());
                EditarTexto.this.setResult(RESULT_OK,regreso);
                EditarTexto.this.finish();
            }
        });
    }
}
