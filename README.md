# Tuna Portal
[대문사진 들어감]

## 🙋‍♀️소개
>예담에서 만난 사람들 <br>
>개발기간 : 2023.00.00 ~ 2024.00.00 <br>
><a href="https://hits.seeyoufarm.com"><img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FTunaPortal%boot&count_bg=%2313E9D6&title_bg=%23555555&icon=github.svg&icon_color=%23E7E7E7&title=%EB%B0%A9%EB%AC%B8%EC%9E%90+%3A+&edge_flat=false"/></a>


## 🙋‍♀️구성원  
| 이름 | 이름 | 이름 | 이름 |
| --- | --- | --- | --- |
| 🙋‍♀️ | 🙋‍♀️ | 🙋‍♀️ | 🙋‍♀️ |
| 깃헙 | 깃헙 | 깃헙 | 깃헙 |
| 담당 | 담당 | 담당 | 담당 |

## 🛠기술 스택
#### FrontEnd
아이콘아이콘

#### BackEnd
아이콘아이콘

#### DB
아이콘아이콘

#### DevOps or Infra
아이콘아이콘

#### Communication
아이콘아이콘

## 🙋‍♀️피그마
[피그마 주소]
## 🙋‍♀️ERD
[ERD 주소]

## 🙋‍♀️주요 기능
1. 🛠 글자를 읽을 수 있다.
    - [아아아아아](#header)   
    - [기능기능기능2](#text-style1)   
    

## 🙋‍♀️화면 구성
| 메인 페이지 | 수강 페이지 |
| --- | --- |
| 사진들어감 | 사진들어감 |

| 이클 페이지 | 참치 페이지 |
| --- | --- |
| 사진들어감 | 사진들어감 |

## 🙋‍♀️아키텍쳐
#### 디렉토리 구조
<details>
<summary>Back</summary>

<details>
<summary>gateway</summary>

```
├── README.md
├── package-lock.json
├── package.json
├── strapi-backend : 
│   ├── README.md
│   ├── api : db model, api 관련 정보 폴더
│   │   ├── about
│   │   ├── course
│   │   └── lecture
│   ├── config : 서버, 데이터베이스 관련 정보 폴더
│   │   ├── database.js
│   │   ├── env : 배포 환경(NODE_ENV = production) 일 때 설정 정보 폴더
│   │   ├── functions : 프로젝트에서 실행되는 함수 관련 정보 폴더
│   │   └── server.js
│   ├── extensions
│   │   └── users-permissions : 권한 정보
│   ├── favicon.ico
│   ├── package-lock.json
│   ├── package.json
│   └── public
│       ├── robots.txt
│       └── uploads : 강의 별 사진
└── voluntain-app : 프론트엔드
    ├── README.md
    ├── components
    │   ├── CourseCard.js
    │   ├── Footer.js
    │   ├── LectureCards.js
    │   ├── MainBanner.js : 메인 페이지에 있는 남색 배너 컴포넌트, 커뮤니티 이름과 슬로건을 포함.
    │   ├── MainCard.js
    │   ├── MainCookieCard.js
    │   ├── NavigationBar.js : 네비게이션 바 컴포넌트, _app.js에서 공통으로 전체 페이지에 포함됨.
    │   ├── RecentLecture.js
    │   └── useWindowSize.js
    ├── config
    │   └── next.config.js
    ├── lib
    │   ├── context.js
    │   └── ga
    ├── next.config.js
    ├── package-lock.json
    ├── package.json
    ├── pages
    │   ├── _app.js
    │   ├── _document.js
    │   ├── about.js
    │   ├── course
    │   ├── index.js
    │   ├── lecture
    │   ├── newcourse
    │   ├── question.js
    │   └── setting.js
    ├── public
    │   ├── favicon.ico
    │   └── logo_about.png
    └── styles
        └── Home.module.css
```
</details>
<details>
<summary>tuna</summary>

```
롸
```
</details>
<details>
<summary>tunaEclass</summary>

```
롸
```
</details>
<details>
<summary>tunaLectureApply</summary>

```
롸
```
</details>

</details>
<details>
<summary>Front</summary>

```
├── README.md
├── package-lock.json
├── package.json
├── strapi-backend : 
│   ├── README.md
│   ├── api : db model, api 관련 정보 폴더
│   │   ├── about
│   │   ├── course
│   │   └── lecture
│   ├── config : 서버, 데이터베이스 관련 정보 폴더
│   │   ├── database.js
│   │   ├── env : 배포 환경(NODE_ENV = production) 일 때 설정 정보 폴더
│   │   ├── functions : 프로젝트에서 실행되는 함수 관련 정보 폴더
│   │   └── server.js
│   ├── extensions
│   │   └── users-permissions : 권한 정보
│   ├── favicon.ico
│   ├── package-lock.json
│   ├── package.json
│   └── public
│       ├── robots.txt
│       └── uploads : 강의 별 사진
└── voluntain-app : 프론트엔드
    ├── README.md
    ├── components
    │   ├── CourseCard.js
    │   ├── Footer.js
    │   ├── LectureCards.js
    │   ├── MainBanner.js : 메인 페이지에 있는 남색 배너 컴포넌트, 커뮤니티 이름과 슬로건을 포함.
    │   ├── MainCard.js
    │   ├── MainCookieCard.js
    │   ├── NavigationBar.js : 네비게이션 바 컴포넌트, _app.js에서 공통으로 전체 페이지에 포함됨.
    │   ├── RecentLecture.js
    │   └── useWindowSize.js
    ├── config
    │   └── next.config.js
    ├── lib
    │   ├── context.js
    │   └── ga
    ├── next.config.js
    ├── package-lock.json
    ├── package.json
    ├── pages
    │   ├── _app.js
    │   ├── _document.js
    │   ├── about.js
    │   ├── course
    │   ├── index.js
    │   ├── lecture
    │   ├── newcourse
    │   ├── question.js
    │   └── setting.js
    ├── public
    │   ├── favicon.ico
    │   └── logo_about.png
    └── styles
        └── Home.module.css
```
</details>
