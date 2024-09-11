package com.example.fetchrewards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewards.adapter.ItemAdapter
import com.example.fetchrewards.repository.ItemViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val viewModel: ItemViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.ItemRecyclerView)
        viewModel.getItemData(this).observe(this) { data ->
            Log.d("onRotate" , "loading")

            // Added android:configChanges="orientation|screenSize" in the manifest to prevent the API from being called again during screen rotation or configuration changes.

            adapter = ItemAdapter(this@MainActivity, data)
            rv.layoutManager = LinearLayoutManager(this@MainActivity)
            rv.adapter = adapter
        }

    }
// **The current implementation is simple and performs the required functionality effectively.
// **Following the MVVM architecture while minimizing unnecessary API calls to optimize performance.

// Improvements can be made in the following areas:
// -> Enhance the UI by incorporating elements like a progress bar, Refresh button for better user experience.
// -> Implement coroutines to manage background tasks more efficiently.
// Other than the UI and coroutine improvements, the app functions as expected and produces the desired results and tried to catch the error as much as possible

// Regarding sorting: Since the name field is a string, sorting it directly will not make sense because it will show 28>276
// I addressed this by separating the name and converting the second element to an integer before applying the sorting logic.
}


