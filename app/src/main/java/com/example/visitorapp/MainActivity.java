package com.example.visitorapp;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;
    String getFName1,getFName2,getFName3,getFName4,text,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.usr);
        e2=(EditText) findViewById(R.id.lnm);
        e3=(EditText) findViewById(R.id.whm);
        e4=(EditText) findViewById(R.id.whm);
        b1=(Button) findViewById(R.id.lgn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFName1=e1.getText().toString();
                getFName2=e2.getText().toString();
                getFName3=e3.getText().toString();
                getFName4=e4.getText().toString();



                if(getFName1.isEmpty())
                {
                    result="Error";
                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                }
                else
                {
                    callAPI();
                }

            }
            private void callAPI() {
                String apiurl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data = new JSONObject();
                try {
                    data.put("ﬁrstname",getFName1);
                    data.put("lastname",getFName2);
                    data.put("purpose",getFName3);
                    data.put("whomToMeet",getFName4);
                }
                catch(JSONException e)
                {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest request=new JsonObjectRequest(
                        Request.Method.POST,
                        apiurl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"get successfully added",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"error occured",Toast.LENGTH_LONG).show()
        );
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(request);


            }
        });





    }

}