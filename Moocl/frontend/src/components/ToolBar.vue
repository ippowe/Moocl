<template>
  <!-- 로그인 로그아웃에 따른 메뉴 내용 변경 -->
  <!-- 로그(side-icon) 눌렀을 때 홈으로 이동 -->
  <!-- 검색 기능 구현 -->
    <v-toolbar dark color="blue lighten-4" height ="75px" >
      <v-toolbar-side-icon to="/main"><img src="../assets/Gurumi_Char.png" class=" pl-5 mt-4" style="height:95px"></v-toolbar-side-icon>
      <v-spacer></v-spacer>
      <v-text-field label="Search" append-icon="search" :append-icon-cb="search" v-model="keyword"
                    solo-inverted style="border-radius :15px" @keyup.enter="search">
      </v-text-field>
      <v-spacer></v-spacer>
      <v-toolbar-items>
        <v-tabs color="transparent" hide-slider>
          <v-tab v-if="loginChecker == 'false'" to="login" style="font-size : 18px;" >
            <strong class="pt-4 ToolBarFont"  >Login</strong>
          </v-tab>
          <v-tab v-if="loginChecker == 'true'" @click="logoutMethod" style="font-size : 18px;">
            <strong class="pt-4 ToolBarFont">Logout</strong>
          </v-tab>
          <v-tab v-if="loginChecker == 'true'" to="mypage" style="font-size : 18px;">
            <strong class="pt-4 ToolBarFont">Mypage</strong>
          </v-tab>
        </v-tabs>
      </v-toolbar-items>

    </v-toolbar>

</template>

<script>
export default {
  name : "ToolBar",
  mounted() {
     if(sessionStorage.length != 0) {
         this.loginChecker = sessionStorage.token
     } else {
        this.loginChecker = 'false'
     }
  },
  watch : {
    keyword(val) {
      //자동 완성 만드는 함수
    }
  },
  data : () => {
    return {
      loginChecker: 'true',
      keyword: ""
    }
  },
  methods : {
    logoutMethod () {
      this.$store.dispatch('LOGOUT')
      .then(() => this.$router.push('login'))
    },
    search () {
      this.$store.state.movie.normalInfoList = [];
      let temp_keyword = "";
      let modifyKeyword = "";
      let currentPage = "";

      temp_keyword = this.keyword;
      modifyKeyword = temp_keyword.replace(/\s/g, "");

      currentPage = this.$router.currentRoute.name
      if(currentPage != 'MainPage'){
        this.$router.push({name : 'MainPage', params: {'keyword' : modifyKeyword}});
      } else {
        this.$router.currentRoute.params['keyword'] = ""
        this.$eventBus.$emit("SearchMovie", modifyKeyword);
      }

      this.keyword = "";
    }
  }
}
</script>

<style lang="css">

.ToolBarFont {color : #00426B !important; font-family: 'Noto_Sans' !important;}
.Logocolor {color: transparent !important;}

</style>
