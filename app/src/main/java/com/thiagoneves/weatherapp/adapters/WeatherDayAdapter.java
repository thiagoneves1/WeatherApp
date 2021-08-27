package com.thiagoneves.weatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thiagoneves.weatherapp.R;
import com.thiagoneves.weatherapp.interfaces.FirstFragmentContract;
import com.thiagoneves.weatherapp.model.CityWeatherInfo;

import java.util.List;

public class WeatherDayAdapter extends RecyclerView.Adapter<WeatherDayAdapter.ViewHolder> {

    private List<CityWeatherInfo> mCityWeatherInfos;
    private FirstFragmentContract.Presenter mListener;

    public WeatherDayAdapter(List<CityWeatherInfo> cityWeatherInfos, FirstFragmentContract.Presenter listener) {
        mCityWeatherInfos = cityWeatherInfos;
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
        CityWeatherInfo cityWeatherInfo = mCityWeatherInfos.get(position);

        holder.textViewDay.setText(cityWeatherInfo.getHumidity());
    }

    public void replaceData(List<CityWeatherInfo> cityWeatherInfos) {
        setList(cityWeatherInfos);
        notifyDataSetChanged();
    }

    private void setList(List<CityWeatherInfo> cityWeatherInfos) {
        mCityWeatherInfos = cityWeatherInfos;
    }

    @Override
    public int getItemCount() {
        return mCityWeatherInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewDay;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(mCityWeatherInfos.get(getAdapterPosition()));
                }
            });

            textViewDay = (TextView) itemView.findViewById(R.id.textViewDay);
        }
    }
}