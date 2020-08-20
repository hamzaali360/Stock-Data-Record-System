Feature: Invalid Post Requests: Catalysts

  Scenario: Invalid catalyst.date
    When the following JSON response is sent
        """
        {
            "history_length" : 1,
            "date" : "2020-07-10",

            "data" : {
            "   symbol" : "UAVS",
                "sector" : "Drone",

                "premarket" : {
                    "high" : {
                        "price" : 1.65,
                        "time" : "7:27"
                    },
                    "low_after_high" : {
                        "price" : 1.59,
                        "time" : "8:01"
                    }
                },

                "panic_bounce" : {
                    "drop" : {
                        "price" : 1.62,
                        "time" : "8:30"
                    },
                    "bottom" : {
                        "price" : 1.55,
                        "time" : "8:36"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            },

            "catalysts" : [
              {
                "date" : "2020-07a-10",
                "time" : "7:27",
                "description" : "Won a contract"
              }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid catalyst.date"



  Scenario: Invalid catalyst.time
    When the following JSON response is sent
        """
        {
            "history_length" : 1,
            "date" : "2020-07-10",

            "data" : {
            "   symbol" : "UAVS",
                "sector" : "Drone",

                "premarket" : {
                    "high" : {
                        "price" : 1.65,
                        "time" : "7:27"
                    },
                    "low_after_high" : {
                        "price" : 1.59,
                        "time" : "8:01"
                    }
                },

                "panic_bounce" : {
                    "drop" : {
                        "price" : 1.62,
                        "time" : "8:30"
                    },
                    "bottom" : {
                        "price" : 1.55,
                        "time" : "8:36"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            },

            "catalysts" : [
              {
                "date" : "2020-07-10",
                "time" : "7:27a",
                "description" : "Won a contract"
              }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid catalyst.time"



  Scenario: Invalid catalyst.description
    When the following JSON response is sent
        """
        {
            "history_length" : 1,
            "date" : "2020-07-10",

            "data" : {
            "   symbol" : "UAVS",
                "sector" : "Drone",

                "premarket" : {
                    "high" : {
                        "price" : 1.65,
                        "time" : "7:27"
                    },
                    "low_after_high" : {
                        "price" : 1.59,
                        "time" : "8:01"
                    }
                },

                "panic_bounce" : {
                    "drop" : {
                        "price" : 1.62,
                        "time" : "8:30"
                    },
                    "bottom" : {
                        "price" : 1.55,
                        "time" : "8:36"
                    },
                    "top" : {
                        "price" : 1.75,
                        "time" : "8:41"
                    }
                }
            },

            "catalysts" : [
              {
                "date" : "2020-07-10",
                "time" : "7:27",
                "description" : ""
              }
            ]
        }
        """
    Then the response code is 400
    And the body is for an "Invalid catalyst.description"