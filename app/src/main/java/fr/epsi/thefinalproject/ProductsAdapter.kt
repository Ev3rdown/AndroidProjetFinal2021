package fr.epsi.thefinalproject

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.app.ActivityOptions
import android.widget.ImageView
import com.squareup.picasso.Picasso


class ProductsAdapter(val products: ArrayList<Product>,val currentActivity: Activity): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    // Define targets in the view
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contentLayoutProductCell = view.findViewById<LinearLayout>(R.id.contentLayoutProductCell)
        val contentLayoutProductCellClickable = view.findViewById<LinearLayout>(R.id.contentLayoutProductCellClickable)
        val textViewProductCellTitle = view.findViewById<TextView>(R.id.textViewProductCellTitle)
        val textViewProductCellDescription = view.findViewById<TextView>(R.id.textViewProductCellDescription)
        val imageViewProductCell = view.findViewById<ImageView>(R.id.imageViewProductCell)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_product, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val product = products.get(position)
        viewHolder.textViewProductCellTitle.text= product.name
        viewHolder.textViewProductCellDescription.text= product.description
        Picasso.get().load(product.picture_url).into(viewHolder.imageViewProductCell)
        viewHolder.contentLayoutProductCellClickable.setOnClickListener {
            //(viewHolder.contentLayoutProductCell.context.applicationContext as AppFinalProject).showToast(product.name)
            val intent = Intent(currentActivity, ProductActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(currentActivity,currentActivity.findViewById(R.id.layout_header),"TopBar").toBundle()
            intent.putExtra("picture_url",product.picture_url)
            intent.putExtra("name",product.name)
            intent.putExtra("description",product.description)
            currentActivity.startActivity(intent, options)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = products.size

}
