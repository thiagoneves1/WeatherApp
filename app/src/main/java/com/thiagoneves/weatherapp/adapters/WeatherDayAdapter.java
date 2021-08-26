package com.thiagoneves.weatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thiagoneves.weatherapp.R;
import com.thiagoneves.weatherapp.interfaces.ItemClickListener;
import com.thiagoneves.weatherapp.model.CityWeather;

import java.util.List;

public class WeatherDayAdapter extends RecyclerView.Adapter<WeatherDayAdapter.ViewHolder> {

    private List<CityWeather> mCityWeathers;
    private ItemClickListener mListener;

    public WeatherDayAdapter(List<CityWeather> cityWeathers, ItemClickListener listener) {
        mCityWeathers = cityWeathers;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.weather_day_item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CityWeather cityWeather = mCityWeathers.get(position);

        holder.textViewDay.setText(cityWeather.getWeekDay());
    }

    @Override
    public int getItemCount() {
        return mCityWeathers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewDay;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(v, getAdapterPosition());
                }
            });

            textViewDay = (TextView) itemView.findViewById(R.id.textViewDay);
        }
    }
}