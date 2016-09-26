-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
  id integer NOT NULL DEFAULT nextval('user_id_seq'::regclass),
  username character varying,
  password character varying,
  last_name character varying,
  email character varying,
  information_user character varying,
  birthday character varying,
  CONSTRAINT pk_id_user PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO postgres;

-- Table: public.user_role

-- DROP TABLE public.user_role;

CREATE TABLE public.user_role
(
  user_id integer NOT NULL,
  role_id integer NOT NULL,
  CONSTRAINT pk_user_id_role_id PRIMARY KEY (user_id, role_id),
  CONSTRAINT fk_user_role_roleid FOREIGN KEY (role_id)
      REFERENCES public.role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_user_role_userid FOREIGN KEY (user_id)
      REFERENCES public.users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.user_role
  OWNER TO postgres;

-- Table: public.role

-- DROP TABLE public.role;

CREATE TABLE public.role
(
  id integer NOT NULL DEFAULT nextval('role_id_seq'::regclass),
  name character varying,
  CONSTRAINT pk_id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.role
  OWNER TO postgres;

- Table: public.photo

-- DROP TABLE public.photo;

CREATE TABLE public.photo
(
  photo_id integer NOT NULL DEFAULT nextval('photo_photo_id_seq'::regclass),
  photo_name character varying,
  gallery_id integer,
  image bytea,
  content_type character varying,
  image_size character varying,
  CONSTRAINT pk_photo_id PRIMARY KEY (photo_id),
  CONSTRAINT fk_gallery_id FOREIGN KEY (gallery_id)
      REFERENCES public.gallery (gallery_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.photo
  OWNER TO postgres;

-- Table: public.gallery

-- DROP TABLE public.gallery;

CREATE TABLE public.gallery
(
  gallery_id integer NOT NULL DEFAULT nextval('gallery_gallery_id_seq'::regclass),
  gallery_name character varying,
  photo_id integer,
  user_id integer,
  CONSTRAINT pk_gallery_id PRIMARY KEY (gallery_id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id)
      REFERENCES public.users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.gallery
  OWNER TO postgres;
