package home.com.br.geradordepessoas;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView firstName;
    private TextView lastName;
    private ProgressDialog load;
    private ImageView foto;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        foto = findViewById(R.id.imageView);
        button = findViewById(R.id.btGetUser);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          GetUser getUser = new GetUser();
                                          getUser.execute();
                                      }
                                  }
        );

    }

    private class GetUser extends AsyncTask<Void, Void, User>{

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this, "Aguarde...", "Buscando usuário...");
        }

        @Override
        protected User doInBackground(Void... voids) {
            UserUtils userUtils = new UserUtils();
            return userUtils.getUser();
        }

        @Override
        protected void onPostExecute(User user){
            firstName.setText(user.getFirstName());
            lastName.setText(user.getLastName());
            foto.setImageBitmap(user.getPicture());
            load.dismiss();
        }
    }
}
