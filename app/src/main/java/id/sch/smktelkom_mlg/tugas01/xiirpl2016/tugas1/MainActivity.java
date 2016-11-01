package id.sch.smktelkom_mlg.tugas01.xiirpl2016.tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etTTL;
    RadioButton rbPerempuan, rbLaki;
    CheckBox cbBaca, cbOR, cbMB;
    Button bSubmit;
    TextView tvHasil;
    RadioGroup rgJK;
    Spinner spPO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTTL = (EditText) findViewById(R.id.editTextTTL);
        rbPerempuan = (RadioButton) findViewById(R.id.radioButtonPerempuan);
        rbLaki = (RadioButton) findViewById(R.id.radioButtonLaki);
        cbBaca = (CheckBox) findViewById(R.id.checkBoxBaca);
        cbOR = (CheckBox) findViewById(R.id.checkBoxOR);
        cbMB = (CheckBox) findViewById(R.id.checkBoxMB);
        bSubmit = (Button) findViewById(R.id.buttonSubmit);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rgJK = (RadioGroup) findViewById(R.id.rgJK);
        spPO = (Spinner) findViewById(R.id.spinnerPekerjaan);

        bSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                doProcess();
            }
        });
            
    }

    private void doProcess()
    {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String TTL = etTTL.getText().toString();
            String hasil = null;

        if (rgJK.getCheckedRadioButtonId() != -1){
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

            String hsl = "Data Diri : ";
            int startlen = hsl.length();
            if (cbBaca.isChecked()) hsl += cbBaca.getText() + "\n";
            if (cbMB.isChecked()) hsl += cbMB.getText() + "\n";
            if (cbOR.isChecked()) hsl += cbOR.getText() + "\n";
            tvHasil.setText("Nama anda : "+nama +"\n Tanggal Lahir : "+TTL +"\n Jenis Kelamin : "+hasil +"\n Hobby : "+hsl +"\n Pekerjaan Orang Tua : "+spPO.getSelectedItem().toString());
        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String TTL = etTTL.getText().toString();

        if (nama.isEmpty())
        {
            etNama.setError("Nama Belum Diisi");
        }
        else
        {
            etNama.setError(null);
        }

        if (TTL.isEmpty())
        {
            etTTL.setError("Tahun Kelahiran Belum Diisi");
        }
        else
        {
            etTTL.setError(null);
        }

        return valid;
    }

}
