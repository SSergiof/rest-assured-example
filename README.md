# rest-assured-example
This project shows a basic set of tests to understand the Rest Assured framework.

The Current Weather Data public API used in this example belongs to [Open Weather Map](https://openweathermap.org/).

***In order to use the Open Weather Map APIs, you will need to create a free account in order to obtain your private API Key.***

## How to obtain your Open Weather Map API Key
1. If not yet done, create a new account.
2. Log into your account.
3. Click on 'API keys' on the navigation sub-menu at the top of the page.
4. If no API key is listed, generate one.
5. If there is an API key already listed, copy it.

## How to open the API documentation
1. If not yet logged to Open Weather Map, log in.
2. Click on 'API' on the navigation menu at the top of the page.
3. Search for 'Current weather data' API within the APIs listed on the page.
4. Once found, click on the 'API doc' button below he API name.
5. Navigate to the 'By city name' resource.
6. Scroll down to the 'Examples of API calls' section for the same resource.
7. Click on the 'api.openweathermap.org/data/2.5/weather?q=London' example.
8. The resource call will open on a new browser tab.
9. In the URL replace the API key at the end with yours and test.
10. The call response should be shown in the page.
11. This is the URL we will use in this project.

## Set your API Key as an environmental variable
1. Execute the following command on a terminal `export OPEN_WEATHER_MAP_API_KEY=<your_api_key>` for MacOS.
2. Execute the following command on CMD `set OPEN_WEATHER_MAP_API_KEY "<your_api_key>"` for Windows.

## Download the project
1. Clone the project by excuting `git clone https://github.com/SSergiof/rest-assured-example.git` or `git clone git@github.com:SSergiof/rest-assured-example.git`