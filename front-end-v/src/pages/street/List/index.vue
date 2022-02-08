<template>
  <div>
    <a-card>
      <div style="padding-bottom: 20px; padding-top: 20px">
        <router-link to="/streets/add">
          <a-button type="primary" icon="plus">
            Add Street
          </a-button>
        </router-link>
        <a-table :pagination="false" :columns="columns" :data-source="data">
          <a slot="name" slot-scope="text">{{ text }}</a>
          <span slot="customTitle">Street Name</span>
          <span slot="district" slot-scope="text">
            <p>{{ text.name }}</p>
         </span>
          <div slot="action" slot-scope="text">
            <a class="button" :href="'/streets/detail/'+ text.id ">
              <a-icon type="info-circle"/>
            </a>
          </div>
        </a-table>
      </div>
    </a-card>
  </div>
</template>
<script>
import StreetService from "@/service/StreetService";
import DistrictService from "@/service/DistrictService";
const columns = [
  {
    dataIndex: 'name',
    key: 'name',
    slots: { title: 'customTitle' },
    scopedSlots: { customRender: 'name' },
  },
  {
    title: 'District',
    dataIndex: 'district',
    key: 'district',
    ellipsis: true,
    scopedSlots: {customRender: 'district'},
  },
  {
    title: 'Description',
    dataIndex: 'description',
    key: 'description',
  },
  {
    title: 'Created at',
    dataIndex: 'created_at',
    key: 'created_at',
  },
  {
    title: 'Status',
    key: 'status',
    dataIndex: 'status',
    scopedSlots: { customRender: 'tags' },
  },
  {
    title: 'Action',
    key: 'action',
    scopedSlots: { customRender: 'action' },
  },
];
export default {
  data(){
    return{
      data: [],
      columns,
      district: []
    }
  },
  created() {
    this.getStreets();
    this.getDistrict()
  },
  methods:{
    getStreets(){
      StreetService.getAll().then(
          res =>{
            console.log(res.data)
            this.data = res.data
          }
      )
    },
    getDistrict(){
      DistrictService.getAll().then(
          res =>{
            console.log(res.data)
            this.district = res.data.district
          }
      )
    }
  }
}
</script>
<style scoped>
/*<!--.product__search-form{-->*/
/*<!--  display: grid;-->*/
/*<!--  gap: 2rem;-->*/
/*<!--  grid-template-columns: repeat(auto-fit,minmax(200px,1fr));-->*/
/*<!--}-->*/
</style>