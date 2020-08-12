Feature: Invalid POST Requests

  Scenario: Invalid symbol
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS1",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid symbol"


  Scenario: Invalid history_length
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 10000,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid history_length (0 - 100)"


  Scenario: Invalid history_length
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 10000,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid history_length (0 - 100)"


  Scenario: Invalid date
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "date",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid date (yyyy-MM-dd)"


  Scenario: Invalid drop_point
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : -1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid drop_point ( d_p > 0 )"


  Scenario: Invalid drop_time
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "a8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid drop_time (HH:mm)"


  Scenario: Invalid bottom_tick
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : -1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid bottom_tick ( b_t > 0 )"


  Scenario: Invalid bottom_time
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "a8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid bottom_time (HH:mm)"


  Scenario: Invalid top_tick
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : -1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid top_tick ( t_t > 0 )"


  Scenario: Invalid top_time
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:4a1",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid top_time (HH:mm)"


  Scenario: Invalid premarket_high
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : -1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid premarket_high ( p_h > 0 )"


  Scenario: Invalid premarket_high_time
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "a0:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid premarket_high_time (HH:mm)"


  Scenario: Invalid premarket_low_after_high
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : -1.59,
            "premarket_low_after_high_time" : "00:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid premarket_low_after_high ( p_l_a_h > 0 )"


  Scenario: Invalid premarket_low_after_high_time
    When the following JSON response is sent
        """
        {
            "symbol" : "UAVS",
            "sector" : "Drone",
            "history_length" : 5,
            "date" : "2020-07-10",
            "drop_point" : 1.62,
            "drop_time" : "8:30",
            "bottom_tick" : 1.55,
            "bottom_time" : "8:36",
            "top_tick" : 1.75,
            "top_time" : "8:41",
            "premarket_high" : 1.65,
            "premarket_high_time" : "00:00",
            "premarket_low_after_high" : 1.59,
            "premarket_low_after_high_time" : "000:00"
        }
        """
    Then the response code is 400
    And the body is "Invalid premarket_low_after_high_time (HH:mm)"