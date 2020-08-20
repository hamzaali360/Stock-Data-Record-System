package com.example.demo.common;


public class ErrorResponseBodies {
    public static String invalid_history_length = "Invalid history_length";
    public static String invalid_date = "Invalid date";
    // data
    public static String invalid_data_symbol = "Invalid data.symbol";
    // data.premarket
    public static String invalid_data_premarket_high_price = "Invalid data.premarket.high.price";
    public static String invalid_data_premarket_high_time = "Invalid data.premarket.high.time";
    public static String invalid_data_premarket_low_after_high_price = "Invalid data.premarket.low_after_high.price";
    public static String invalid_data_premarket_low_after_high_time = "Invalid data.premarket.low_after_high.time";
    // data.panic_bounce
    public static String invalid_data_panic_bounce_drop_price = "Invalid data.panic_bounce.drop.price";
    public static String invalid_data_panic_bounce_drop_time = "Invalid data.panic_bounce.drop.time";
    public static String invalid_data_panic_bounce_bottom_price = "Invalid data.panic_bounce.bottom.price";
    public static String invalid_data_panic_bounce_bottom_time = "Invalid data.panic_bounce.bottom.time";
    public static String invalid_data_panic_bounce_top_price = "Invalid data.panic_bounce.top.price";
    public static String invalid_data_panic_bounce_top_time = "Invalid data.panic_bounce.top.time";
    // technical_indicator_behaviors
    public static String invalid_technical_indicator_behaviors_price = "Invalid technical_indicator_behaviors.price";
    public static String invalid_technical_indicator_behaviors_time = "Invalid technical_indicator_behaviors.time";
    public static String invalid_technical_indicator_behaviors_type = "Invalid technical_indicator_behaviors.type";
    // key_levels
    public static String invalid_key_levels_price = "Invalid key_levels.price";
    public static String invalid_key_levels_type = "Invalid key_levels.type";
    // failed_bounces
    public static String invalid_failed_bounces_drop_price = "Invalid failed_bounces.drop.price";
    public static String invalid_failed_bounces_drop_time = "Invalid failed_bounces.drop.time";
    public static String invalid_failed_bounces_bottom_price = "Invalid failed_bounces.bottom.price";
    public static String invalid_failed_bounces_bottom_time = "Invalid failed_bounces.bottom.time";
    public static String invalid_failed_bounces_top_price = "Invalid failed_bounces.top.price";
    public static String invalid_failed_bounces_top_time = "Invalid failed_bounces.top.time";
    // pullback_bounces
    public static String invalid_pullback_bounces_drop_price = "Invalid pullback_bounces.drop.price";
    public static String invalid_pullback_bounces_drop_time = "Invalid pullback_bounces.drop.time";
    public static String invalid_pullback_bounces_bottom_price = "Invalid pullback_bounces.bottom.price";
    public static String invalid_pullback_bounces_bottom_time = "Invalid pullback_bounces.bottom.time";
    public static String invalid_pullback_bounces_top_price = "Invalid pullback_bounces.top.price";
    public static String invalid_pullback_bounces_top_time = "Invalid pullback_bounces.top.time";
    // failed_morning_spikes
    public static String invalid_failed_morning_spikes_start_price = "Invalid failed_morning_spikes.start.price";
    public static String invalid_failed_morning_spikes_start_time = "Invalid failed_morning_spikes.start.time";
    public static String invalid_failed_morning_spikes_top_price = "Invalid failed_morning_spikes.top.price";
    public static String invalid_failed_morning_spikes_top_time = "Invalid failed_morning_spikes.top.time";
    public static String invalid_failed_morning_spikes_bottom_price = "Invalid failed_morning_spikes.bottom.price";
    public static String invalid_failed_morning_spikes_bottom_time = "Invalid failed_morning_spikes.bottom.time";
    // catalysts
    public static String invalid_catalyst_date = "Invalid catalyst.date";
    public static String invalid_catalyst_time = "Invalid catalyst.time";
    public static String invalid_catalyst_description = "Invalid catalyst.description";


    private static String history_range = "(0 - 100)";
    private static String date_format = "(yyyy-MM-dd)";
    private static String time_format = "(HH:mm)";
    private static String positive_dollar = "($ > 0)";


    public static String get(String key){
             if(key.equals(invalid_history_length)){ return invalid_history_length+" "+history_range; }
        else if(key.equals(invalid_date)){ return invalid_date+" "+date_format; }
        // data
        else if(key.equals(invalid_data_symbol)){ return  invalid_data_symbol; }
        // data.premarket
        else if(key.equals(invalid_data_premarket_high_price)){ return invalid_data_premarket_high_price+" "+positive_dollar; }
        else if(key.equals(invalid_data_premarket_high_time)){ return invalid_data_premarket_high_time+" "+time_format; }
        else if(key.equals(invalid_data_premarket_low_after_high_price)){ return invalid_data_premarket_low_after_high_price+" "+positive_dollar; }
        else if(key.equals(invalid_data_premarket_low_after_high_time)){ return invalid_data_premarket_low_after_high_time+" "+time_format; }
        // panic_bounce
        else if(key.equals(invalid_data_panic_bounce_drop_price)){ return invalid_data_panic_bounce_drop_price+" "+positive_dollar; }
        else if(key.equals(invalid_data_panic_bounce_drop_time)){ return invalid_data_panic_bounce_drop_time+" "+time_format; }
        else if(key.equals(invalid_data_panic_bounce_bottom_price)){ return invalid_data_panic_bounce_bottom_price+" "+positive_dollar; }
        else if(key.equals(invalid_data_panic_bounce_bottom_time)){ return invalid_data_panic_bounce_bottom_time+" "+time_format; }
        else if(key.equals(invalid_data_panic_bounce_top_price)){ return invalid_data_panic_bounce_top_price+" "+positive_dollar; }
        else if(key.equals(invalid_data_panic_bounce_top_time)){ return invalid_data_panic_bounce_top_time+" "+time_format; }
        // technical_indicator_behaviors
        else if(key.equals(invalid_technical_indicator_behaviors_price)){ return invalid_technical_indicator_behaviors_price+" "+positive_dollar; }
        else if(key.equals(invalid_technical_indicator_behaviors_time)){ return invalid_technical_indicator_behaviors_time+" "+time_format; }
        else if(key.equals(invalid_technical_indicator_behaviors_type)){ return invalid_technical_indicator_behaviors_type; }
        // key_levels
        else if(key.equals(invalid_key_levels_price)){ return invalid_key_levels_price+" "+positive_dollar; }
        else if(key.equals(invalid_key_levels_type)){ return invalid_key_levels_type; }
        // failed_bounces
        else if(key.equals(invalid_failed_bounces_drop_price)){ return invalid_failed_bounces_drop_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_bounces_drop_time)){ return invalid_failed_bounces_drop_time+" "+time_format; }
        else if(key.equals(invalid_failed_bounces_bottom_price)){ return invalid_failed_bounces_bottom_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_bounces_bottom_time)){ return invalid_failed_bounces_bottom_time+" "+time_format; }
        else if(key.equals(invalid_failed_bounces_top_price)){ return invalid_failed_bounces_top_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_bounces_top_time)){ return invalid_failed_bounces_top_time+" "+time_format; }
        // pullback_bounces
        else if(key.equals(invalid_pullback_bounces_drop_price)){ return invalid_pullback_bounces_drop_price+" "+positive_dollar; }
        else if(key.equals(invalid_pullback_bounces_drop_time)){ return invalid_pullback_bounces_drop_time+" "+time_format; }
        else if(key.equals(invalid_pullback_bounces_bottom_price)){ return invalid_pullback_bounces_bottom_price+" "+positive_dollar; }
        else if(key.equals(invalid_pullback_bounces_bottom_time)){ return invalid_pullback_bounces_bottom_time+" "+time_format; }
        else if(key.equals(invalid_pullback_bounces_top_price)){ return invalid_pullback_bounces_top_price+" "+positive_dollar; }
        else if(key.equals(invalid_pullback_bounces_top_time)){ return invalid_pullback_bounces_top_time+" "+time_format; }
        // failed_morning_spikes
        else if(key.equals(invalid_failed_morning_spikes_start_price)){ return invalid_failed_morning_spikes_start_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_morning_spikes_start_time)){ return invalid_failed_morning_spikes_start_time+" "+time_format; }
        else if(key.equals(invalid_failed_morning_spikes_top_price)){ return invalid_failed_morning_spikes_top_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_morning_spikes_top_time)){ return invalid_failed_morning_spikes_top_time+" "+time_format; }
        else if(key.equals(invalid_failed_morning_spikes_bottom_price)){ return invalid_failed_morning_spikes_bottom_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_morning_spikes_bottom_time)){ return invalid_failed_morning_spikes_bottom_time+" "+time_format; }
        // catalyst
        else if (key.equals(invalid_catalyst_date)){ return invalid_catalyst_date+" "+date_format; }
        else if (key.equals(invalid_catalyst_time)){ return invalid_catalyst_time+" "+time_format; }
        else if (key.equals(invalid_catalyst_description)){ return invalid_catalyst_description+" (missing or too long)"; }



        else{ return "Response body key not found"; }
    }

}
