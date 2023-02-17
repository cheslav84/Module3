BEGIN;


CREATE TABLE IF NOT EXISTS public.class
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT class_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.flyway_schema_history
(
    installed_rank integer NOT NULL,
    version character varying(50) COLLATE pg_catalog."default",
    description character varying(200) COLLATE pg_catalog."default" NOT NULL,
    type character varying(20) COLLATE pg_catalog."default" NOT NULL,
    script character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    checksum integer,
    installed_by character varying(100) COLLATE pg_catalog."default" NOT NULL,
    installed_on timestamp without time zone NOT NULL DEFAULT now(),
    execution_time integer NOT NULL,
    success boolean NOT NULL,
    CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank)
);

CREATE TABLE IF NOT EXISTS public.grade
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    value integer NOT NULL,
    student_id character varying(255) COLLATE pg_catalog."default",
    subject_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT grade_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.mentor
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    subject_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT mentor_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.person
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    age integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    surname character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.student
(
    entry_date timestamp without time zone,
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    class_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT student_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.subject
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT subject_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.grade
    ADD CONSTRAINT fkep37ymuxqe45lfaysrimbrs2a FOREIGN KEY (subject_id)
    REFERENCES public.subject (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.grade
    ADD CONSTRAINT fknrmfyw3u4l459wuii4g9nrb1b FOREIGN KEY (student_id)
    REFERENCES public.student (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;


ALTER TABLE IF EXISTS public.mentor
    ADD CONSTRAINT fk45mbm13u8fqrpsdwaigo1juml FOREIGN KEY (id)
    REFERENCES public.person (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS mentor_pkey
    ON public.mentor(id);


ALTER TABLE IF EXISTS public.mentor
    ADD CONSTRAINT fk9p3ddbscwgodgxdewro5drj7b FOREIGN KEY (subject_id)
    REFERENCES public.subject (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.student
    ADD CONSTRAINT fk3bkmp4kohbl54m14tb2fcqya3 FOREIGN KEY (id)
    REFERENCES public.person (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS student_pkey
    ON public.student(id);


ALTER TABLE IF EXISTS public.student
    ADD CONSTRAINT fkmba2123p70ksifgolaf5q6s8k FOREIGN KEY (class_id)
    REFERENCES public.class (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;

END;