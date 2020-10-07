CREATE VIEW "customers_sequence_view" AS SELECT nextval('customers_sequence_generator') as ID;
CREATE VIEW "customers_business_sequence_view" AS SELECT nextval('customers_business_sequence_generator') as ID;
CREATE VIEW "customers_histories_sequence_view" AS SELECT nextval('customers_histories_sequence_generator') as ID;
CREATE VIEW "customers_list_sequence_view" AS SELECT nextval('customers_list_sequence_generator') as ID;
CREATE VIEW "customers_list_favourites_sequence_view" AS SELECT nextval('customers_list_favourites_sequence_generator') as ID;
CREATE VIEW "customers_list_members_sequence_view" AS SELECT nextval('customers_list_members_sequence_generator') as ID;
CREATE VIEW "customers_list_participants_sequence_view" AS SELECT nextval('customers_list_participants_sequence_generator') as ID;
CREATE VIEW "customers_list_search_conditions_sequence_view" AS SELECT nextval('customers_list_search_conditions_sequence_generator') as ID;
CREATE VIEW "masters_motivations_sequence_view" AS SELECT nextval('masters_motivations_sequence_generator') as ID;
CREATE VIEW "masters_scenarios_sequence_view" AS SELECT nextval('masters_scenarios_sequence_generator') as ID;
CREATE VIEW "masters_scenarios_details_sequence_view" AS SELECT nextval('masters_scenarios_details_sequence_generator') as ID;
CREATE VIEW "masters_stands_sequence_view" AS SELECT nextval('masters_stands_sequence_generator') as ID;
CREATE VIEW "network_stands_sequence_view" AS SELECT nextval('network_stands_sequence_generator') as ID;