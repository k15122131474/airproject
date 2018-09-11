/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/11/28 10:16:29                          */
/*==============================================================*/

/*==============================================================*/
/* DataBase: create database profitmeasurementos                */
/*==============================================================*/
drop database if EXISTS profitmeasurementos;
create database profitmeasurementos CHARACTER SET utf8 COLLATE utf8_general_ci;

/*==============================================================*/
/* Tables: create tables of the database                        */
/*==============================================================*/

use profitmeasurementos;

drop table if exists annual_prodect_removal;
drop table if exists land_planning;
drop table if exists other_expenses;
drop table if exists prodect_de;
drop table if exists product;
drop table if exists profit_combination;
drop table if exists profit_maximization;
drop table if exists user;
drop table if exists user_log;

/*==============================================================*/
/* Table: annual_prodect_removal                                */
/*==============================================================*/
create table annual_prodect_removal
(
   annualprodectremoval int not null,
   prodectdeid          int,
   what_year            varchar(20),
   annual_price         decimal(12,4),
   de_area              decimal(12,4),
   annual_amount        decimal(12,4),
   unit_price           decimal(12,4),
   primary key (annualprodectremoval)
);

/*==============================================================*/
/* Table: land_planning                                         */
/*==============================================================*/
create table land_planning
(
   landplanningid       int not null,
   userid               int,
   parcel_name          varchar(30),
   enterprise_name      varchar(30),
   land_pirce           decimal(15,4),
   land_area            decimal(15,4),
   volume_limit         decimal(10,4),
   density_limit        decimal(10,4),
   green_space_limit    decimal(10,4),
   effective_year       decimal(6),
   create_time          datetime,
   update_time          datetime,
   ultimate_volume_ratio decimal(15,4),
   ultimate_building_density decimal(15,4),
   primary key (landplanningid)
);

/*==============================================================*/
/* Table: other_expenses                                        */
/*==============================================================*/
create table other_expenses
(
   otherexpensesid      int not null,
   landplanning         int,
   userid               int,
   underground_building_are decimal(14,4),
   unilateral_cost_underground decimal(14,4),
   total_underground_cost decimal(14,4),
   total_value_underground decimal(14,4),
   upfront_fee          decimal(14,4),
   equipment_facilities decimal(14,4),
   unforeseen_expenses  decimal(14,4),
   garden_engineering_fee decimal(14,4),
   community_waterway   decimal(14,4),
   ancillary_facilities_fee decimal(14,4),
   selling_expenses     decimal(14,4),
   management_expenses  decimal(14,4),
   financial_expenses   decimal(14,4),
   value_added_tax      decimal(14,4),
   increment_tax        decimal(14,4),
   income_tax           decimal(14,4),
   other_costs1         decimal(14,4),
   other_costs2         decimal(14,4),
   other_costs3         decimal(14,4),
   other_costs4         decimal(14,4),
   other_costs5         decimal(14,4),
   other_total_costs    decimal(14,4),
   create_time          datetime,
   update_time          datetime,
   other_costs1_name    varchar(40),
   other_costs2_name    varchar(40),
   other_costs3_name    varchar(40),
   other_costs4_name    varchar(40),
   other_costs5_name    varchar(40),
   primary key (otherexpensesid)
);

/*==============================================================*/
/* Table: prodect_de                                            */
/*==============================================================*/
create table prodect_de
(
   prodectdeid          int not null,
   prodectid            int,
   import_time          datetime,
   average_selling_price numeric(12,4),
   contribution_value_square numeric(12,4),
   contribution_value_cash numeric(12,4),
   superimposed_price   numeric(12,4),
   price_increase       numeric(12,4),
   capital_interest     numeric(12,4),
   url_name             varchar(50),
   primary key (prodectdeid)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   productid            int not null,
   userid_create        int,
   userid_update        int,
   otherexpenses        int,
   cell_area            decimal(12,4),
   product_name         varchar(30),
   limiting_volume      decimal(12,4),
   number_doors         int,
   floor_area_unit      decimal(12,4),
   construction_cost    decimal(12,4),
   preset_plrice        decimal(12,4),
   isgoto               char(1),
   create_time          datetime,
   update_time          datetime,
   url_name             varchar(30),
   primary key (productid)
);

/*==============================================================*/
/* Table: profit_combination                                    */
/*==============================================================*/
create table profit_combination
(
   profitcombinationid  int not null,
   landplanningid       char(10),
   userid               char(10),
   type                 char(1),
   combination_name     varchar(15),
   adjusted_profit      decimal(13,4),
   total_value_adjustment decimal(13,4),
   actual_volume_rate   decimal(8,4),
   actual_building_density decimal(8,4),
   total_value          decimal(13,4),
   gross_profit         decimal(13,4),
   create_time          datetime,
   primary key (profitcombinationid)
);

/*==============================================================*/
/* Table: profit_maximization                                   */
/*==============================================================*/
create table profit_maximization
(
   profitmaxmizationid  int not null,
   profitcombination    int,
   product_name         varchar(30),
   builtup_area         decimal(12,4),
   area_proportion      decimal(8,4),
   number_door_units    decimal(8,2),
   cell_area            decimal(12,4),
   prodectid            int,
   primary key (profitmaxmizationid)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userid               int not null,
   username             varchar(20),
   password             varchar(10),
   isbegin              char(2),
   role                 varchar(20),
   enterprise_name      varchar(50),
   create_time          datetime,
   update_time          datetime,
   primary key (userid)
);

/*==============================================================*/
/* Table: user_log                                              */
/*==============================================================*/
create table user_log
(
   userlogid            int,
   ip                   char(20),
   login_time           datetime,
   userid               int
);