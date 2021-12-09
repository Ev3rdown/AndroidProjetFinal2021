package fr.epsi.thefinalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class CategoriesAdapter(val categories: ArrayList<Category>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    // Define targets in the view
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewCategoryTitle = view.findViewById<TextView>(R.id.textViewCategoryTitle)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayoutCategory)
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
        viewHolder.textViewCategoryTitle.text= category.title
        viewHolder.contentLayout.setOnClickListener {
            (viewHolder.contentLayout.context.applicationContext as AppFinalProject).showToast(category.title)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = categories.size

}
