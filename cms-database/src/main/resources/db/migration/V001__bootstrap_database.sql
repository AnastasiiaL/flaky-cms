-- Application tables

create table REVINFO
(
    id            bigint identity                             not null,
    timestamp     bigint                                      not null,
    username      varchar(255)                                not null,
    notes         varchar(255)                                not null,
    affectedStart datetimeoffset(6)
        constraint DF_REVINFO_affectedStart default getdate() not null,
    affectedEnd   datetimeoffset(6)
        constraint DF_REVINFO_affectedEnd default getdate()   not null,
    constraint PK_REVINFO primary key clustered (id),
)

create table SomeImportantValues
(
    id                                          bigint identity not null,
    effective                                   date            not null,
    temperature                                 numeric(15, 9)  not null,
    temperature1                                numeric(15, 9)  not null,
    temperature2                                numeric(15, 9)  not null,
    limit1                                      numeric(15, 9)  not null,
    limit2                                      numeric(15, 9)  not null,
    limit3                                      numeric(15, 9)  not null,
    position1                                   numeric(15, 9)  not null,
    position2                                   numeric(15, 9)  not null,
    position3                                   numeric(15, 9)  not null,
    hours1                                      numeric(15, 9)  not null,
    hours2                                      numeric(15, 9)  not null,
    hours3                                      numeric(15, 9)  not null,
    foo                                         numeric(15, 9)  not null,
    bar                                         numeric(15, 9)  not null,
    anotherField                                numeric(15, 9)  not null,
    yetAnother                                  numeric(15, 9)  not null,
    andTheLastOne                               numeric(15, 9)  not null,
    constraint PK_SomeImportantValues primary key clustered (id),
    constraint UK_SomeImportantValues_effective unique (effective)
)

create table SomeImportantValues_AUD
(
    id                                              bigint         not null,
    REV                                             bigint         not null,
    REVTYPE                                         smallint       not null,
    effective                                       date           not null,
    effective_MOD                                   bit            not null,
    temperature                                     numeric(15, 9) not null,
    temperature_MOD                                 bit            not null,
    temperature1                                    numeric(15, 9) not null,
    temperature1_MOD                                bit            not null,
    temperature2                                    numeric(15, 9) not null,
    temperature2_MOD                                bit            not null,
    limit1                                          numeric(15, 9) not null,
    limit1_MOD                                      bit            not null,
    limit2                                          numeric(15, 9) not null,
    limit2_MOD                                      bit            not null,
    limit3                                          numeric(15, 9) not null,
    limit3_MOD                                      bit            not null,
    position1                                       numeric(15, 9) not null,
    position1_MOD                                   bit            not null,
    position2                                       numeric(15, 9) not null,
    position2_MOD                                   bit            not null,
    position3                                       numeric(15, 9) not null,
    position3_MOD                                   bit            not null,
    hours1                                          numeric(15, 9) not null,
    hours1_MOD                                      bit            not null,
    hours2                                          numeric(15, 9) not null,
    hours2_MOD                                      bit            not null,
    hours3                                          numeric(15, 9) not null,
    hours3_MOD                                      bit            not null,
    foo                                             numeric(15, 9) not null,
    foo_MOD                                         bit            not null,
    bar                                             numeric(15, 9) not null,
    bar_MOD                                         bit            not null,
    anotherField                                    numeric(15, 9) not null,
    anotherField_MOD                                bit            not null,
    yetAnother                                      numeric(15, 9) not null,
    yetAnother_MOD                                  bit            not null,
    andTheLastOne                                   numeric(15, 9) not null,
    andTheLastOne_MOD                               bit            not null,
    constraint PK_SomeImportantValues_AUD primary key clustered (id, REV),
    constraint FK_SomeImportantValues_AUD_REVINFO foreign key (REV) references REVINFO
)

create table Limits
(
    id                                              bigint identity not null,
    effective                                       date not null,
    thresholdB                                      INT not null,
    thresholdC                                      INT not null,
    thresholdD                                      INT not null,
    thresholdE                                      INT not null,
    thresholdF                                      INT not null,
    thresholdG                                      INT not null,
    thresholdH                                      INT not null,
    thresholdI                                      INT not null,
    thresholdJ                                      INT not null,
    thresholdK                                      INT not null,
    bar1                                            numeric(15, 9) not null,
    bar2                                            numeric(15, 9) not null,
    bar3                                            numeric(15, 9) not null,
    bar4                                            numeric(15, 9) not null,
    constraint PK_Limits primary key clustered (id),
    constraint UK_Limits_effective unique (effective)
)

create table Limits_AUD
(
    id                                              bigint not null,
    REV                                             bigint not null,
    REVTYPE                                         smallint not null,
    effective                                       date not null,
    effective_MOD                                   bit not null,
    thresholdB                                      INT not null,
    thresholdB_MOD                                  bit not null,
    thresholdC                                      INT not null,
    thresholdC_MOD                                  bit not null,
    thresholdD                                      INT not null,
    thresholdD_MOD                                  bit not null,
    thresholdE                                      INT not null,
    thresholdE_MOD                                  bit not null,
    thresholdF                                      INT not null,
    thresholdF_MOD                                  bit not null,
    thresholdG                                      INT not null,
    thresholdG_MOD                                  bit not null,
    thresholdH                                      INT not null,
    thresholdH_MOD                                  bit not null,
    thresholdI                                      INT not null,
    thresholdI_MOD                                  bit not null,
    thresholdJ                                      INT not null,
    thresholdJ_MOD                                  bit not null,
    thresholdK                                      INT not null,
    thresholdK_MOD                                  bit not null,
    bar1                                            numeric(15, 9) not null,
    bar1_MOD                                        bit not null,
    bar2                                            numeric(15, 9) not null,
    bar2_MOD                                        bit not null,
    bar3                                            numeric(15, 9) not null,
    bar3_MOD                                        bit not null,
    bar4                                            numeric(15, 9) not null,
    bar4_MOD                                        bit not null,
    constraint PK_Limits_AUD primary key clustered (id, REV),
    constraint FK_Limits_AUD_REVINFO foreign key (REV) references REVINFO
)

create table PartyPlace
(
   date                                date primary key,
   place                               varchar(256) not null
)

create table PartyPlace_AUD
(
   date                                            date not null,
   REV                                             bigint not null,
   REVTYPE                                         smallint not null,
   place                                           varchar(256) not null,
   place_MOD                                       bit not null,
   constraint PK_PartyPlace_AUD primary key clustered (date, REV),
   constraint FK_PartyPlace_AUD_REVINFO foreign key (REV) references REVINFO
)

create table Test
(
    id              bigint identity not null,
    effective       date            not null,
    foo10 numeric(6, 3)  not null,
    foo20 numeric(6, 3)  not null,
    bar10  numeric(6, 3)  not null,
    bar20  numeric(6, 3)  not null,
    constraint PK_Test primary key clustered (id)
)

create table Test_AUD
(
    id                  bigint          not null,
    REV                 bigint          not null,
    REVTYPE             smallint        not null,
    effective           date            not null,
    effective_MOD       bit             not null,
    foo10     numeric(6, 3)  not null,
    foo10_MOD bit             not null,
    foo20     numeric(6, 3)  not null,
    foo20_MOD bit             not null,
    bar10      numeric(6, 3)  not null,
    bar10_MOD  bit             not null,
    bar20      numeric(6, 3)  not null,
    bar20_MOD  bit             not null,
    constraint PK_Test_AUD primary key clustered (id, REV),
    constraint FK_Test_AUD_REVINFO foreign key (REV) references REVINFO
)

INSERT INTO Limits (
    effective, thresholdB, thresholdC, thresholdD, thresholdE, thresholdF, thresholdG, thresholdH, thresholdI, thresholdJ, thresholdK, bar1, bar2,
    bar3, bar4) VALUES ('2015-03-01', '32', '32', '160', '320', '320', '0', '0', '0', '0', '0', '13', '13', '13', '13');
