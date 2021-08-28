package com.thiagoneves.weatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.thiagoneves.weatherapp.R;
import com.thiagoneves.weatherapp.interfaces.FirstFragmentContract;
import com.thiagoneves.weatherapp.model.CityWeatherInfoDay;
import com.thiagoneves.weatherapp.model.Weather;
import com.thiagoneves.weatherapp.model.WeatherIcon;
import com.thiagoneves.weatherapp.util.FormatterUtil;

import java.util.List;

public class WeatherDayAdapter extends RecyclerView.Adapter<WeatherDayAdapter.ViewHolder> {

    private List<Weather> mWathers;
    private FirstFragmentContract.Presenter mListener;

    public WeatherDayAdapter(List<Weather> weathers, FirstFragmentContract.Presenter listener) {
        mWathers = weathers;
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
        CityWeatherInfoDay cityWeatherInfoDay = mWathers.get(position).getCityWeatherInfos().get(0); //TODO to adjust this

        holder.textViewDay.setText(cityWeatherInfoDay.getApplicableDate());
        holder.textMin.setText(FormatterUtil.getFormattedValue(cityWeatherInfoDay.getMinTemp()));
        holder.textMax.setText(FormatterUtil.getFormattedValue(cityWeatherInfoDay.getMaxTemp()));
        holder.textCurrent.setText(FormatterUtil.getFormattedValue(cityWeatherInfoDay.getCurrentTemp()));
        holder.textWeatherName.setText(cityWeatherInfoDay.getWeatherStateName());
        WeatherIcon weatherIcon = WeatherIcon.getByApiName(cityWeatherInfoDay.getWeatherStateName());
        holder.imageViewWeatherIcon.setBackground(ContextCompat.getDrawable(holder.imageViewWeatherIcon.getContext(), weatherIcon.getDrawableId()));
    }

    public void replaceData(List<Weather> weathers) {
        setList(weathers);
        notifyDataSetChanged();
    }

    private void setList(List<Weather> weathers) {
        mWathers = weathers;
    }

    @Override
    public int getItemCount() {
        return mWathers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewDay, textWeatherName, textMax, textMin, textCurrent;
        public ImageView imageViewWeatherIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(mWathers.get(0).getCityWeatherInfos().get(getAdapterPosition()));
                }
            });

            textViewDay = (TextView) itemView.findViewById(R.id.textViewDay);
            textWeatherName = (TextView) itemView.findViewById(R.id.textWeatherName);
            textMax = (TextView) itemView.findViewById(R.id.textMax);
            textMin = (TextView) itemView.findViewById(R.id.textMin);
            textCurrent = (TextView) itemView.findViewById(R.id.textCurrent);
            imageViewWeatherIcon = (ImageView) itemView.findViewById(R.id.imageIconWeather);
        }
    }
}