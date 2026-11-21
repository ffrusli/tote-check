

# Automated Tote Checker

Automated Tote Checker is a small Java and Spring Boot service that compares a customer's order with the items detected in a delivery tote, and answers PASS or DIVERT before the tote leaves the warehouse.

## The problem

When a grocery tote is packed wrongly, the customer receives missing or wrong items and has to report it. Fixing it means extra deliveries, extra work for staff and extra cost, and it damages the customer's trust in the service.
Catching the mistake before the tote leaves the warehouse avoids all of that: it is far cheaper to fix a tote at the conveyor than at the customer's door.

## How it works

1. An order exists: a list of items with quantities.
2. A reader at the conveyor sends the tote ID and a batch of detected item IDs.
3. The service compares the two and answers MATCHED ("good to go") or UNMATCHED, listing what is missing and what is extra, with quantities.

No cameras or AI: this project is only the checking logic. The scanner input is simulated, with item IDs sent to the service as text.

## Tech stack

- **Java**: the brain. Compares the order with the detected items and builds the result.
- **Spring Boot**: the plumbing and the front desk. Receives requests from the conveyor reader, passes them to the Java logic, and sends the answer back.
- **PostgreSQL**: the database. Stores the item catalog (ID to name) and the order lists.

## Project status

| Feature | Phase | Status |
|---------|-------|--------|
| Core checking logic in plain Java | Core | ⬜ Not started |
| PostgreSQL tables for items and orders | Core | ⬜ Not started |
| REST API (submit order, submit scan, get result) | Core | ⬜ Not started |
| Unit tests | Core | ⬜ Not started |
| Out-of-stock note on missing items | Stretch | ⬜ Not started |
| Weight check | Future | ⬜ Not started |
| Hardware demo: ESP32 with an RFID reader sending scans over Wi-Fi | Future | ⬜ Not started |
| Tote or box size suggestion | Future | ⬜ Not started |
| Add missing items to the next delivery, with tracking | Future | ⬜ Not started |


## Known limitations

- Plain barcodes give no unique ID per item, so a double-read by the scanner cannot be told apart from a genuine second item.
- The scanner is simulated, so there is no real hardware input (an ESP32 reader demo is planned as a later extension).

## Future work

Weight-based checks, a more realistic first extension than item-level tagging (which is costly for groceries), plus RFID or camera input, box size suggestions, and automatically adding missing items to the customer's next delivery.

_Inspired by the idea of catching tote mistakes before they reach the customer. A learning project, in progress._

