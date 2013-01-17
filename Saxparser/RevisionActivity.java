package com.paradigmcreatives.revision;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class RevisionActivity extends Activity implements OnClickListener {

	private Button mButton;
	private ListView mListView;
	private List<UserXml> users = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_revision);

		mButton = (Button) findViewById(R.id.parse_button);
		mListView = (ListView) findViewById(R.id.details_list);

		mButton.setOnClickListener(this);

	}

	public void onClick(View v) {

		try {
			users = XmlParser.parse(getAssets().open("vi.txt"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < users.size(); i++) {
				list.add(users.get(i).getFirstname() + " "
						+ users.get(i).getLastname());
			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					R.layout.dialog, R.id.name, list);
			mListView.setAdapter(adapter);

		} catch (IOException setter) {
			// TODO Auto-generated catch block
			setter.printStackTrace();
		}

	}
}
