***This app is restful api for purchase demonstration***

API controllers:
1) Feature calculate-price - calculates price using product id, tax number, coupon code
2) Feature purchase - fix order with product id, tax number, coupon code and payment processor

Technical features:
1) Database integration
2) Make sale using coupon code
3) Different coupon sale types (fix and percent)
4) Tax calculate by tax number and price
5) 2 payment processors types


Launch instructions
1) download Docker on your system
2) download project
3) change directory to /docker
4) launch launch.sh in terminal "sh launch.sh" (for Linux or GitBash)
5) Note that you need to have launched postgresql with credentials described in application.yaml and at least one row in table main.products