package us.opcam.camera.view;

import java.util.ArrayList;

import us.opcam.camera.R;
import us.opcam.camera.util.ImageItem;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @author javatechig {@link http://javatechig.com}
 * 
 */
public class GridViewAdapter extends ArrayAdapter<ImageItem>
{
	private Context context;
	private int layoutResourceId;
	private ArrayList<ImageItem> data = new ArrayList<ImageItem>();

	public GridViewAdapter(Context context, int layoutResourceId, ArrayList<ImageItem> data)
	{
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		ViewHolder holder = null;

		if (row == null)
		{
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			holder = new ViewHolder();
			holder.imageTitle = (TextView) row.findViewById(R.id.text);
			holder.image = (ImageView) row.findViewById(R.id.image);
			row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}

		ImageItem item = data.get(position);
		holder.imageTitle.setText(item.getTitle());
		
		
		
		holder.image.setImageBitmap(item.getImage());
		return row;
	}

	@Override
	public int getCount()
	{
		return data.size();
	}

	@Override
	public ImageItem getItem(int position)
	{
		return data.get(position);
		//return null;
	}

	@Override
	public long getItemId(int position)
	{
		return 0;
	}

	static class ViewHolder
	{
		TextView imageTitle;
		ImageView image;
	}
}