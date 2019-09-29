-- public schema

-- !Ups
CREATE TABLE my_transactions (
    id bigint NOT NULL ,
    t_amount decimal NOT NULL,
    t_date timestamp with time zone,
    PRIMARY KEY (id)
);

create sequence my_transactions_seq;
alter table my_transactions alter column id set default nextval('my_transactions_seq');


-- !Downs
DROP TABLE my_transactions;
DROP sequence my_transactions_seq;