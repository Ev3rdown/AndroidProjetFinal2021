package fr.epsi.thefinalproject

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import android.app.ActivityOptions


class CategoriesAdapter(val categories: ArrayList<Category>,val currentActivity: Activity): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    // Define targets in the view
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val buttonCategoryTitle = view.findViewById<TextView>(R.id.buttonCategoryTitle)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val category = categories.get(position)
        viewHolder.buttonCategoryTitle.text= category.title
        viewHolder.buttonCategoryTitle.setOnClickListener {
            val intent = Intent(currentActivity, ProductsActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(currentActivity,currentActivity.findViewById(R.id.layout_header),"TopBar").toBundle()
            intent.putExtra("products_url",category.products_url)
            intent.putExtra("title",category.title)
            currentActivity.startActivity(intent, options)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = categories.size

}
