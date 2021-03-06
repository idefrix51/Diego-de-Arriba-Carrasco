PGDMP                          z           gacelapatientapp    14.2    14.2 F    K           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            L           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            M           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            N           1262    16394    gacelapatientapp    DATABASE     l   CREATE DATABASE gacelapatientapp WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
     DROP DATABASE gacelapatientapp;
                postgres    false            ?            1259    16489    calorias_diarias_corporales    TABLE       CREATE TABLE public.calorias_diarias_corporales (
    calorias_diarias_corporales_id integer NOT NULL,
    id_registro_var_fisica integer NOT NULL,
    calorias_diarias_totales integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    opt_lock integer NOT NULL
);
 /   DROP TABLE public.calorias_diarias_corporales;
       public         heap    postgres    false            ?            1259    16488 >   calorias_diarias_corporales_calorias_diarias_corporales_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.calorias_diarias_corporales_calorias_diarias_corporales_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 U   DROP SEQUENCE public.calorias_diarias_corporales_calorias_diarias_corporales_id_seq;
       public          postgres    false    228            O           0    0 >   calorias_diarias_corporales_calorias_diarias_corporales_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.calorias_diarias_corporales_calorias_diarias_corporales_id_seq OWNED BY public.calorias_diarias_corporales.calorias_diarias_corporales_id;
          public          postgres    false    227            ?            1259    16424 
   ci_medicas    TABLE     ?   CREATE TABLE public.ci_medicas (
    ci_medica_id integer NOT NULL,
    id_paciente integer NOT NULL,
    id_ci_tipo integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    anotacion character varying(25),
    opt_lock integer NOT NULL
);
    DROP TABLE public.ci_medicas;
       public         heap    postgres    false            ?            1259    16423    ci_medicas_ci_medica_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.ci_medicas_ci_medica_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.ci_medicas_ci_medica_id_seq;
       public          postgres    false    210            P           0    0    ci_medicas_ci_medica_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.ci_medicas_ci_medica_id_seq OWNED BY public.ci_medicas.ci_medica_id;
          public          postgres    false    209            ?            1259    16431    ci_tipos    TABLE     ?   CREATE TABLE public.ci_tipos (
    ci_tipo_id integer NOT NULL,
    nombre character varying(30),
    descripcion character varying(200),
    opt_lock integer NOT NULL
);
    DROP TABLE public.ci_tipos;
       public         heap    postgres    false            ?            1259    16430    ci_tipos_ci_tipo_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.ci_tipos_ci_tipo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.ci_tipos_ci_tipo_id_seq;
       public          postgres    false    212            Q           0    0    ci_tipos_ci_tipo_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.ci_tipos_ci_tipo_id_seq OWNED BY public.ci_tipos.ci_tipo_id;
          public          postgres    false    211            ?            1259    16673    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    16438    historicos_clinicos    TABLE     0  CREATE TABLE public.historicos_clinicos (
    histo_clinicos_id integer NOT NULL,
    id_paciente integer NOT NULL,
    id_variable integer NOT NULL,
    fecha_registro timestamp without time zone NOT NULL,
    valor_int integer,
    valor_varchar character varying(20),
    opt_lock integer NOT NULL
);
 '   DROP TABLE public.historicos_clinicos;
       public         heap    postgres    false            ?            1259    16437 )   historicos_clinicos_histo_clinicos_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.historicos_clinicos_histo_clinicos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 @   DROP SEQUENCE public.historicos_clinicos_histo_clinicos_id_seq;
       public          postgres    false    214            R           0    0 )   historicos_clinicos_histo_clinicos_id_seq    SEQUENCE OWNED BY     w   ALTER SEQUENCE public.historicos_clinicos_histo_clinicos_id_seq OWNED BY public.historicos_clinicos.histo_clinicos_id;
          public          postgres    false    213            ?            1259    16466    historicos_dosis    TABLE     ?   CREATE TABLE public.historicos_dosis (
    historico_dosis_id integer NOT NULL,
    id_medipaciente integer NOT NULL,
    dosis boolean DEFAULT false,
    fecha timestamp without time zone NOT NULL,
    opt_lock integer NOT NULL
);
 $   DROP TABLE public.historicos_dosis;
       public         heap    postgres    false            ?            1259    16465 '   historicos_dosis_historico_dosis_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.historicos_dosis_historico_dosis_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 >   DROP SEQUENCE public.historicos_dosis_historico_dosis_id_seq;
       public          postgres    false    222            S           0    0 '   historicos_dosis_historico_dosis_id_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public.historicos_dosis_historico_dosis_id_seq OWNED BY public.historicos_dosis.historico_dosis_id;
          public          postgres    false    221            ?            1259    16459    medicamentos    TABLE     ?   CREATE TABLE public.medicamentos (
    medicamento_id integer NOT NULL,
    nombre character varying(30),
    descripcion character varying(200),
    opt_lock integer NOT NULL
);
     DROP TABLE public.medicamentos;
       public         heap    postgres    false            ?            1259    16458    medicamentos_medicamento_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.medicamentos_medicamento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.medicamentos_medicamento_id_seq;
       public          postgres    false    220            T           0    0    medicamentos_medicamento_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.medicamentos_medicamento_id_seq OWNED BY public.medicamentos.medicamento_id;
          public          postgres    false    219            ?            1259    16452    medipacientes    TABLE     ?   CREATE TABLE public.medipacientes (
    medipaciente_id integer NOT NULL,
    id_paciente integer NOT NULL,
    id_medicamento integer NOT NULL,
    cantidad integer,
    opt_lock integer NOT NULL
);
 !   DROP TABLE public.medipacientes;
       public         heap    postgres    false            ?            1259    16451 !   medipacientes_medipaciente_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.medipacientes_medipaciente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.medipacientes_medipaciente_id_seq;
       public          postgres    false    218            U           0    0 !   medipacientes_medipaciente_id_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.medipacientes_medipaciente_id_seq OWNED BY public.medipacientes.medipaciente_id;
          public          postgres    false    217            ?            1259    16674 	   pacientes    TABLE     :  CREATE TABLE public.pacientes (
    id integer NOT NULL,
    nombre character varying(255),
    apellidos character varying(255),
    fecha_nacimiento timestamp without time zone,
    genero character varying(255),
    cip_autonomico character varying(255),
    cip_nacional character varying(255),
    nif character varying(255),
    domicilio character varying(255),
    mobile_phone character varying(255),
    email character varying(255),
    tutor_legal character varying(255),
    foto bytea,
    password character varying(255),
    opt_lock integer NOT NULL
);
    DROP TABLE public.pacientes;
       public         heap    postgres    false            ?            1259    16475    registro_var_fisicas    TABLE        CREATE TABLE public.registro_var_fisicas (
    registro_var_fisica_id integer NOT NULL,
    id_paciente integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    peso integer,
    c_diarias integer,
    altura integer,
    peso_ideal integer,
    opt_lock integer NOT NULL
);
 (   DROP TABLE public.registro_var_fisicas;
       public         heap    postgres    false            ?            1259    16474 /   registro_var_fisicas_registro_var_fisica_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.registro_var_fisicas_registro_var_fisica_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 F   DROP SEQUENCE public.registro_var_fisicas_registro_var_fisica_id_seq;
       public          postgres    false    224            V           0    0 /   registro_var_fisicas_registro_var_fisica_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.registro_var_fisicas_registro_var_fisica_id_seq OWNED BY public.registro_var_fisicas.registro_var_fisica_id;
          public          postgres    false    223            ?            1259    16482    registros_googlefit    TABLE     _  CREATE TABLE public.registros_googlefit (
    registro_google_fit_id integer NOT NULL,
    id_registro_var_fisica integer NOT NULL,
    id_calorias_diarias_corporales integer NOT NULL,
    calorias_consumidas integer,
    distancia_recorrida integer,
    pasos integer,
    fecha timestamp without time zone NOT NULL,
    opt_lock integer NOT NULL
);
 '   DROP TABLE public.registros_googlefit;
       public         heap    postgres    false            ?            1259    16481 .   registros_googlefit_registro_google_fit_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.registros_googlefit_registro_google_fit_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 E   DROP SEQUENCE public.registros_googlefit_registro_google_fit_id_seq;
       public          postgres    false    226            W           0    0 .   registros_googlefit_registro_google_fit_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.registros_googlefit_registro_google_fit_id_seq OWNED BY public.registros_googlefit.registro_google_fit_id;
          public          postgres    false    225            ?            1259    16445 	   variables    TABLE     ?   CREATE TABLE public.variables (
    variable_id integer NOT NULL,
    nombre character varying(30),
    numerico integer,
    descripcion character varying(200),
    opt_lock integer NOT NULL
);
    DROP TABLE public.variables;
       public         heap    postgres    false            ?            1259    16444    variables_variable_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.variables_variable_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.variables_variable_id_seq;
       public          postgres    false    216            X           0    0    variables_variable_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.variables_variable_id_seq OWNED BY public.variables.variable_id;
          public          postgres    false    215            ?           2604    16492 :   calorias_diarias_corporales calorias_diarias_corporales_id    DEFAULT     ?   ALTER TABLE ONLY public.calorias_diarias_corporales ALTER COLUMN calorias_diarias_corporales_id SET DEFAULT nextval('public.calorias_diarias_corporales_calorias_diarias_corporales_id_seq'::regclass);
 i   ALTER TABLE public.calorias_diarias_corporales ALTER COLUMN calorias_diarias_corporales_id DROP DEFAULT;
       public          postgres    false    228    227    228            ?           2604    16427    ci_medicas ci_medica_id    DEFAULT     ?   ALTER TABLE ONLY public.ci_medicas ALTER COLUMN ci_medica_id SET DEFAULT nextval('public.ci_medicas_ci_medica_id_seq'::regclass);
 F   ALTER TABLE public.ci_medicas ALTER COLUMN ci_medica_id DROP DEFAULT;
       public          postgres    false    209    210    210            ?           2604    16434    ci_tipos ci_tipo_id    DEFAULT     z   ALTER TABLE ONLY public.ci_tipos ALTER COLUMN ci_tipo_id SET DEFAULT nextval('public.ci_tipos_ci_tipo_id_seq'::regclass);
 B   ALTER TABLE public.ci_tipos ALTER COLUMN ci_tipo_id DROP DEFAULT;
       public          postgres    false    212    211    212            ?           2604    16441 %   historicos_clinicos histo_clinicos_id    DEFAULT     ?   ALTER TABLE ONLY public.historicos_clinicos ALTER COLUMN histo_clinicos_id SET DEFAULT nextval('public.historicos_clinicos_histo_clinicos_id_seq'::regclass);
 T   ALTER TABLE public.historicos_clinicos ALTER COLUMN histo_clinicos_id DROP DEFAULT;
       public          postgres    false    213    214    214            ?           2604    16469 #   historicos_dosis historico_dosis_id    DEFAULT     ?   ALTER TABLE ONLY public.historicos_dosis ALTER COLUMN historico_dosis_id SET DEFAULT nextval('public.historicos_dosis_historico_dosis_id_seq'::regclass);
 R   ALTER TABLE public.historicos_dosis ALTER COLUMN historico_dosis_id DROP DEFAULT;
       public          postgres    false    221    222    222            ?           2604    16462    medicamentos medicamento_id    DEFAULT     ?   ALTER TABLE ONLY public.medicamentos ALTER COLUMN medicamento_id SET DEFAULT nextval('public.medicamentos_medicamento_id_seq'::regclass);
 J   ALTER TABLE public.medicamentos ALTER COLUMN medicamento_id DROP DEFAULT;
       public          postgres    false    220    219    220            ?           2604    16455    medipacientes medipaciente_id    DEFAULT     ?   ALTER TABLE ONLY public.medipacientes ALTER COLUMN medipaciente_id SET DEFAULT nextval('public.medipacientes_medipaciente_id_seq'::regclass);
 L   ALTER TABLE public.medipacientes ALTER COLUMN medipaciente_id DROP DEFAULT;
       public          postgres    false    218    217    218            ?           2604    16478 +   registro_var_fisicas registro_var_fisica_id    DEFAULT     ?   ALTER TABLE ONLY public.registro_var_fisicas ALTER COLUMN registro_var_fisica_id SET DEFAULT nextval('public.registro_var_fisicas_registro_var_fisica_id_seq'::regclass);
 Z   ALTER TABLE public.registro_var_fisicas ALTER COLUMN registro_var_fisica_id DROP DEFAULT;
       public          postgres    false    223    224    224            ?           2604    16485 *   registros_googlefit registro_google_fit_id    DEFAULT     ?   ALTER TABLE ONLY public.registros_googlefit ALTER COLUMN registro_google_fit_id SET DEFAULT nextval('public.registros_googlefit_registro_google_fit_id_seq'::regclass);
 Y   ALTER TABLE public.registros_googlefit ALTER COLUMN registro_google_fit_id DROP DEFAULT;
       public          postgres    false    225    226    226            ?           2604    16448    variables variable_id    DEFAULT     ~   ALTER TABLE ONLY public.variables ALTER COLUMN variable_id SET DEFAULT nextval('public.variables_variable_id_seq'::regclass);
 D   ALTER TABLE public.variables ALTER COLUMN variable_id DROP DEFAULT;
       public          postgres    false    215    216    216            ?           2606    16494 <   calorias_diarias_corporales calorias_diarias_corporales_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.calorias_diarias_corporales
    ADD CONSTRAINT calorias_diarias_corporales_pkey PRIMARY KEY (calorias_diarias_corporales_id);
 f   ALTER TABLE ONLY public.calorias_diarias_corporales DROP CONSTRAINT calorias_diarias_corporales_pkey;
       public            postgres    false    228            ?           2606    16429    ci_medicas ci_medicas_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.ci_medicas
    ADD CONSTRAINT ci_medicas_pkey PRIMARY KEY (ci_medica_id);
 D   ALTER TABLE ONLY public.ci_medicas DROP CONSTRAINT ci_medicas_pkey;
       public            postgres    false    210            ?           2606    16436    ci_tipos ci_tipos_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.ci_tipos
    ADD CONSTRAINT ci_tipos_pkey PRIMARY KEY (ci_tipo_id);
 @   ALTER TABLE ONLY public.ci_tipos DROP CONSTRAINT ci_tipos_pkey;
       public            postgres    false    212            ?           2606    16443 ,   historicos_clinicos historicos_clinicos_pkey 
   CONSTRAINT     y   ALTER TABLE ONLY public.historicos_clinicos
    ADD CONSTRAINT historicos_clinicos_pkey PRIMARY KEY (histo_clinicos_id);
 V   ALTER TABLE ONLY public.historicos_clinicos DROP CONSTRAINT historicos_clinicos_pkey;
       public            postgres    false    214            ?           2606    16472 &   historicos_dosis historicos_dosis_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.historicos_dosis
    ADD CONSTRAINT historicos_dosis_pkey PRIMARY KEY (historico_dosis_id);
 P   ALTER TABLE ONLY public.historicos_dosis DROP CONSTRAINT historicos_dosis_pkey;
       public            postgres    false    222            ?           2606    16464    medicamentos medicamentos_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.medicamentos
    ADD CONSTRAINT medicamentos_pkey PRIMARY KEY (medicamento_id);
 H   ALTER TABLE ONLY public.medicamentos DROP CONSTRAINT medicamentos_pkey;
       public            postgres    false    220            ?           2606    16457     medipacientes medipacientes_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.medipacientes
    ADD CONSTRAINT medipacientes_pkey PRIMARY KEY (medipaciente_id);
 J   ALTER TABLE ONLY public.medipacientes DROP CONSTRAINT medipacientes_pkey;
       public            postgres    false    218            ?           2606    16680    pacientes pacientes_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.pacientes
    ADD CONSTRAINT pacientes_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.pacientes DROP CONSTRAINT pacientes_pkey;
       public            postgres    false    230            ?           2606    16480 .   registro_var_fisicas registro_var_fisicas_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.registro_var_fisicas
    ADD CONSTRAINT registro_var_fisicas_pkey PRIMARY KEY (registro_var_fisica_id);
 X   ALTER TABLE ONLY public.registro_var_fisicas DROP CONSTRAINT registro_var_fisicas_pkey;
       public            postgres    false    224            ?           2606    16487 ,   registros_googlefit registros_googlefit_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public.registros_googlefit
    ADD CONSTRAINT registros_googlefit_pkey PRIMARY KEY (registro_google_fit_id);
 V   ALTER TABLE ONLY public.registros_googlefit DROP CONSTRAINT registros_googlefit_pkey;
       public            postgres    false    226            ?           2606    16726    pacientes unicodni 
   CONSTRAINT     L   ALTER TABLE ONLY public.pacientes
    ADD CONSTRAINT unicodni UNIQUE (nif);
 <   ALTER TABLE ONLY public.pacientes DROP CONSTRAINT unicodni;
       public            postgres    false    230            ?           2606    16728    pacientes unicoemail 
   CONSTRAINT     P   ALTER TABLE ONLY public.pacientes
    ADD CONSTRAINT unicoemail UNIQUE (email);
 >   ALTER TABLE ONLY public.pacientes DROP CONSTRAINT unicoemail;
       public            postgres    false    230            ?           2606    16450    variables variables_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.variables
    ADD CONSTRAINT variables_pkey PRIMARY KEY (variable_id);
 B   ALTER TABLE ONLY public.variables DROP CONSTRAINT variables_pkey;
       public            postgres    false    216            ?           2606    16535 S   calorias_diarias_corporales calorias_diarias_corporales_id_registro_var_fisica_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.calorias_diarias_corporales
    ADD CONSTRAINT calorias_diarias_corporales_id_registro_var_fisica_fkey FOREIGN KEY (id_registro_var_fisica) REFERENCES public.registro_var_fisicas(registro_var_fisica_id) ON DELETE CASCADE;
 }   ALTER TABLE ONLY public.calorias_diarias_corporales DROP CONSTRAINT calorias_diarias_corporales_id_registro_var_fisica_fkey;
       public          postgres    false    228    3240    224            ?           2606    16500 %   ci_medicas ci_medicas_id_ci_tipo_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ci_medicas
    ADD CONSTRAINT ci_medicas_id_ci_tipo_fkey FOREIGN KEY (id_ci_tipo) REFERENCES public.ci_tipos(ci_tipo_id) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.ci_medicas DROP CONSTRAINT ci_medicas_id_ci_tipo_fkey;
       public          postgres    false    3228    212    210            ?           2606    16681 &   ci_medicas ci_medicas_id_paciente_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ci_medicas
    ADD CONSTRAINT ci_medicas_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES public.pacientes(id) ON DELETE CASCADE;
 P   ALTER TABLE ONLY public.ci_medicas DROP CONSTRAINT ci_medicas_id_paciente_fkey;
       public          postgres    false    230    210    3246            ?           2606    16686 8   historicos_clinicos historicos_clinicos_id_paciente_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.historicos_clinicos
    ADD CONSTRAINT historicos_clinicos_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES public.pacientes(id) ON DELETE CASCADE;
 b   ALTER TABLE ONLY public.historicos_clinicos DROP CONSTRAINT historicos_clinicos_id_paciente_fkey;
       public          postgres    false    214    3246    230            ?           2606    16510 8   historicos_clinicos historicos_clinicos_id_variable_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.historicos_clinicos
    ADD CONSTRAINT historicos_clinicos_id_variable_fkey FOREIGN KEY (id_variable) REFERENCES public.variables(variable_id) ON DELETE CASCADE;
 b   ALTER TABLE ONLY public.historicos_clinicos DROP CONSTRAINT historicos_clinicos_id_variable_fkey;
       public          postgres    false    214    3232    216            ?           2606    16525 6   historicos_dosis historicos_dosis_id_medipaciente_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.historicos_dosis
    ADD CONSTRAINT historicos_dosis_id_medipaciente_fkey FOREIGN KEY (id_medipaciente) REFERENCES public.medipacientes(medipaciente_id) ON DELETE CASCADE;
 `   ALTER TABLE ONLY public.historicos_dosis DROP CONSTRAINT historicos_dosis_id_medipaciente_fkey;
       public          postgres    false    3234    222    218            ?           2606    16520 /   medipacientes medipacientes_id_medicamento_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.medipacientes
    ADD CONSTRAINT medipacientes_id_medicamento_fkey FOREIGN KEY (id_medicamento) REFERENCES public.medicamentos(medicamento_id) ON DELETE CASCADE;
 Y   ALTER TABLE ONLY public.medipacientes DROP CONSTRAINT medipacientes_id_medicamento_fkey;
       public          postgres    false    3236    218    220            ?           2606    16691 ,   medipacientes medipacientes_id_paciente_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.medipacientes
    ADD CONSTRAINT medipacientes_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES public.pacientes(id) ON DELETE CASCADE;
 V   ALTER TABLE ONLY public.medipacientes DROP CONSTRAINT medipacientes_id_paciente_fkey;
       public          postgres    false    230    3246    218            ?           2606    16696 :   registro_var_fisicas registro_var_fisicas_id_paciente_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.registro_var_fisicas
    ADD CONSTRAINT registro_var_fisicas_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES public.pacientes(id) ON DELETE CASCADE;
 d   ALTER TABLE ONLY public.registro_var_fisicas DROP CONSTRAINT registro_var_fisicas_id_paciente_fkey;
       public          postgres    false    230    224    3246            ?           2606    16545 K   registros_googlefit registros_googlefit_id_calorias_diarias_corporales_fkey    FK CONSTRAINT       ALTER TABLE ONLY public.registros_googlefit
    ADD CONSTRAINT registros_googlefit_id_calorias_diarias_corporales_fkey FOREIGN KEY (id_calorias_diarias_corporales) REFERENCES public.calorias_diarias_corporales(calorias_diarias_corporales_id) ON DELETE CASCADE;
 u   ALTER TABLE ONLY public.registros_googlefit DROP CONSTRAINT registros_googlefit_id_calorias_diarias_corporales_fkey;
       public          postgres    false    226    228    3244            ?           2606    16540 C   registros_googlefit registros_googlefit_id_registro_var_fisica_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.registros_googlefit
    ADD CONSTRAINT registros_googlefit_id_registro_var_fisica_fkey FOREIGN KEY (id_registro_var_fisica) REFERENCES public.registro_var_fisicas(registro_var_fisica_id) ON DELETE CASCADE;
 m   ALTER TABLE ONLY public.registros_googlefit DROP CONSTRAINT registros_googlefit_id_registro_var_fisica_fkey;
       public          postgres    false    226    3240    224           